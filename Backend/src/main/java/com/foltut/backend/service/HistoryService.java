package com.foltut.backend.service;

import com.foltut.backend.builder.historyBuilder.HistoryBuilder;
import com.foltut.backend.dto.historyDTO.HistoryDTO;
import com.foltut.backend.enums.Opperation;
import com.foltut.backend.model.History;
import com.foltut.backend.model.User;
import com.foltut.backend.repository.HistoryRepository;
import com.foltut.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HistoryService {

    @Autowired
    private HistoryRepository historyRepository;

    @Autowired
    private UserService userService;

    public History createHistory(History history){
            return historyRepository.save(history);
    }

    public List<HistoryDTO> getHistoriesForUser(){

        User performer = userService.getUsernameFromSecurityContext();
        return historyRepository.findByPerformer(performer)
                .stream()
                .map(HistoryBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

    public List<HistoryDTO> getParkingLogs(){
        User performer = userService.getUsernameFromSecurityContext();

        return  historyRepository.findByPerformer(performer)
                .stream()
                .filter(history -> history.getOpperation().equals(Opperation.PARK_CAR) || history.getOpperation().equals(Opperation.EXIT_PARK))
                .map(HistoryBuilder::generateDTOFromEntity)
                .collect(Collectors.toList());
    }

}
