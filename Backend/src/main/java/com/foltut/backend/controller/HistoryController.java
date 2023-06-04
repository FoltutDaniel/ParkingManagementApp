package com.foltut.backend.controller;

import com.foltut.backend.dto.historyDTO.HistoryDTO;
import com.foltut.backend.model.History;
import com.foltut.backend.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/history")
@CrossOrigin
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/parking-logs")
    public List<HistoryDTO> getParkingLogs(){
        return historyService.getParkingLogs();
    }
}
