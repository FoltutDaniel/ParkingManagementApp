package com.foltut.backend.controller;

import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.dto.requestDTO.ParkingRequestDTO;
import com.foltut.backend.service.ParkingLotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/parking")
public class ParkingLotController {

    @Autowired
    private ParkingLotService parkingLotService;

    @PostMapping("/save")
    public Long saveParkingLot(@RequestBody()ParkingLotDTO parkingLotDTO){
        return parkingLotService.saveParkingLot(parkingLotDTO);
    }

    @GetMapping("/all")
    public List<ParkingLotDTO> getAllParkingLots(){
        return parkingLotService.getAllParkingLots();
    }

    @PutMapping("/park")
    public Boolean parkCar(@RequestBody() ParkingRequestDTO parkingRequestDTO){
        return parkingLotService.parkCar(parkingRequestDTO);
    }

}
