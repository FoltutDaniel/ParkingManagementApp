package com.foltut.backend.builder.historyBuilder;

import com.foltut.backend.dto.historyDTO.HistoryDTO;
import com.foltut.backend.model.History;

public class HistoryBuilder {

    public static HistoryDTO generateDTOFromEntity(History history){
        return new HistoryDTO(history.getId(),
                history.getPerformer(),
                history.getInformation(),
                history.getOpperation(),
                history.getCreationDate());
    }
}
