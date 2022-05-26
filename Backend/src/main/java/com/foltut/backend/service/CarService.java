package com.foltut.backend.service;

import com.foltut.backend.builder.carBuilder.CarBuilder;
import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.dto.carDTO.CarRegisterDTO;
import com.foltut.backend.enums.Opperation;
import com.foltut.backend.exception.ResourceNotFoundException;
import com.foltut.backend.model.Car;
import com.foltut.backend.model.History;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.CarRepository;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HistoryService historyService;

    @Autowired UserService userService;

        public Long registerCar(CarRegisterDTO carRegisterDTO){

        User carOwner = userService.getUsernameFromSecurityContext();

            Car newCar = new Car(carRegisterDTO.getLicensePlate(),
                    carRegisterDTO.getBrand().toLowerCase(Locale.ROOT),
                    carOwner);

            newCar.setParkingStatus(false);
            carRepository.save(newCar);

            String information = String.format("User %s registered a new car with license plate: %s", carOwner.getUsername(), newCar.getLicensePlate());
            History newHistory = new History(carOwner, information, Opperation.REGISTER_CAR);
            historyService.createHistory(newHistory);

            return  newCar.getId();

    }

    public Long removeCar(String licensePlate){

            User carOwner = userService.getUsernameFromSecurityContext();
            Optional<Car> carToRemove = carRepository.findByLicensePlate(licensePlate);
            if(!carToRemove.isPresent()){
                throw new ResourceNotFoundException("Car", "Car license plate", licensePlate);
            }else{
                carRepository.delete(carToRemove.get());

                String information = String.format("User %s removed car with license plate: %s", carOwner.getUsername(), licensePlate);
                History newHistory = new History(carOwner, information, Opperation.REMOVE_CAR);
                historyService.createHistory(newHistory);

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
