package com.foltut.backend.service;

import com.foltut.backend.builder.parkingLotBuilder.ParkingLotBuilder;
import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.dto.requestDTO.ParkingRequestDTO;
import com.foltut.backend.exception.ResourceNotFoundException;
import com.foltut.backend.exception.SubscriptionExpiredException;
import com.foltut.backend.model.Car;
import com.foltut.backend.model.ParkingLot;
import com.foltut.backend.repository.CarRepository;
import com.foltut.backend.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

    @Autowired
    private CarRepository carRepository;

    public Long saveParkingLot(ParkingLotDTO parkingLotDTO){

        ParkingLot newParkingLot = ParkingLotBuilder.generateEntityFromDTO(parkingLotDTO);
        parkingLotRepository.save(newParkingLot);

        return newParkingLot.getId();
    }

    public List<ParkingLotDTO> getAllParkingLots(){
        return StreamSupport
                .stream(parkingLotRepository.findAll().spliterator(),false)
                .map(ParkingLotBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public Boolean parkCar(ParkingRequestDTO parkingRequestDTO){
        Optional<Car> car = carRepository.findByLicensePlate(parkingRequestDTO.getLicensePlate());
        if(!car.isPresent()){
            throw new ResourceNotFoundException("Car", "Car license plate", parkingRequestDTO.getLicensePlate());
        }
        Optional<ParkingLot> parkingLot = parkingLotRepository.findById(parkingRequestDTO.getParkingLotId());
        if(!parkingLot.isPresent()){
            throw new ResourceNotFoundException("Parking lot", "Parking lot id", parkingRequestDTO.getParkingLotId());
        }

        if(car.get().getSubscription() == null){
            throw new ResourceNotFoundException("Subscription", "Subscription for car with license plate", parkingRequestDTO.getLicensePlate());
        }
        if(car.get().getSubscription().getEndDate().isBefore(LocalDate.now())){
            throw new SubscriptionExpiredException(car.get().getLicensePlate());
        }

        if(car.get().getParkingStatus() == false && (parkingLot.get().getMaxCapacity() - parkingLot.get().getCars().size())>0){
            parkingLot.get().addCar(car.get());
            car.get().setParkingStatus(true);
            carRepository.save(car.get());
            parkingLotRepository.save(parkingLot.get());
            return true;
        }else if(car.get().getParkingStatus() == true){
            parkingLot.get().removeCar(car.get());
            car.get().setParkingStatus(false);
            carRepository.save(car.get());
            parkingLotRepository.save(parkingLot.get());
            return true;
        }

        return false;

    }


}
