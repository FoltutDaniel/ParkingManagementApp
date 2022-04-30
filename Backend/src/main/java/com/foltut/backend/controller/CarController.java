package com.foltut.backend.controller;

import com.foltut.backend.dto.carDTO.CarDTO;
import com.foltut.backend.dto.carDTO.CarRegisterDTO;
import com.foltut.backend.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/register")
    public Long registerCar(@RequestBody()CarRegisterDTO carRegisterDTO){
        return carService.registerCar(carRegisterDTO);
    }

    @GetMapping("/getPlates/{userId}")
    public List<String> getLicensePlates(@PathVariable("userId") Long ownerId){
        return carService.getOwnedCarsNumberPlates(ownerId);
    }

    @DeleteMapping("/{licensePlate}")
    public Long removeCar(@PathVariable("licensePlate") String licensePlate){
        return carService.removeCar(licensePlate);
    }

    @GetMapping("/all/{userId}")
    public List<CarDTO> getCarsForUser(@PathVariable("userId") Long userId){
        return carService.getAllCarsForUser(userId);
    }



}
