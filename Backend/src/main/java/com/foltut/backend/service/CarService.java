package com.foltut.backend.service;

import com.foltut.backend.builder.carBuilder.CarBuilder;
import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.dto.carDTO.CarRegisterDTO;
import com.foltut.backend.exception.ResourceNotFoundException;
import com.foltut.backend.model.Car;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.CarRepository;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

        public Long registerCar(CarRegisterDTO carRegisterDTO){

        Optional<User> carOwner = userRepository.findById(carRegisterDTO.getOwnerId());
        if(!carOwner.isPresent()){
            throw new ResourceNotFoundException("User", "User id", carRegisterDTO.getOwnerId());
        }else {
            Car newCar = new Car(carRegisterDTO.getLicensePlate(),
                    carRegisterDTO.getBrand(),
                    carOwner.get());

            newCar.setParkingStatus(false);
            carRepository.save(newCar);
            return  newCar.getId();
        }
    }

    public Long removeCar(String licensePlate){

            Optional<Car> carToRemove = carRepository.findByLicensePlate(licensePlate);
            if(!carToRemove.isPresent()){
                throw new ResourceNotFoundException("Car", "Car license plate", licensePlate);
            }else{
                carRepository.delete(carToRemove.get());
                return carToRemove.get().getId();
            }
    }

    public List<CarDTO> getAllCarsForUser(Long userId){

            Optional<User> user = userRepository.findById(userId);
            if(!user.isPresent()){
                throw new ResourceNotFoundException("User", "User id", userId);
            }else{
                return user.get()
                        .getCars()
                        .stream()
                        .map(CarBuilder::generateDTOFromEntity)
                        .collect(Collectors.toList());
            }
    }

    public List<String> getOwnedCarsNumberPlates(Long userId){

        Optional<User> user = userRepository.findById(userId);
        if(!user.isPresent()){
            throw new ResourceNotFoundException("User", "User id", userId);
        }else{
            return user.get()
                    .getCars()
                    .stream()
                    .filter(car -> car.getSubscription() == null)
                    .map(Car::getLicensePlate)
                    .collect(Collectors.toList());
        }

    }
}
