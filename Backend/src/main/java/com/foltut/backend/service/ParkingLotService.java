package com.foltut.backend.service;

import com.foltut.backend.builder.parkingLotBuilder.ParkingLotBuilder;
import com.foltut.backend.dto.ParkingLotDTO.ParkingLotDTO;
import com.foltut.backend.model.ParkingLot;
import com.foltut.backend.repository.ParkingLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ParkingLotService {

    @Autowired
    private ParkingLotRepository parkingLotRepository;

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


}
