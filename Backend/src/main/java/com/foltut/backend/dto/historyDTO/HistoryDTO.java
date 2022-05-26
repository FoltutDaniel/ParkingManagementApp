package com.foltut.backend.dto.historyDTO;

import com.foltut.backend.enums.Opperation;
import com.foltut.backend.model.User;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

public class HistoryDTO {

    private Long id;

    private User performer;

    private String information;

    private Opperation opperation;

    private LocalDateTime creationDate;

    public HistoryDTO() {
    }

    public HistoryDTO(Long id, User performer, String information, Opperation opperation, LocalDateTime creationDate) {
        this.id = id;
        this.performer = performer;
        this.information = information;
        this.opperation = opperation;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getPerformer() {
        return performer;
    }

    public void setPerformer(User performer) {
        this.performer = performer;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    public Opperation getOpperation() {
        return opperation;
    }

    public void setOpperation(Opperation opperation) {
        this.opperation = opperation;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
