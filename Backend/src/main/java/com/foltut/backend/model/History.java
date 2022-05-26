package com.foltut.backend.model;

import com.foltut.backend.enums.Opperation;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "performer_id", nullable = false)
    private User performer;

    @Column(name = "information")
    private String information;

    @Enumerated(EnumType.ORDINAL)
    private Opperation opperation;

    @CreationTimestamp
    @Column(name = "creation_date")
    private LocalDateTime creationDate;

    public History() {
    }

    public History(User performer, String information, Opperation opperation) {
        this.performer = performer;
        this.information = information;
        this.opperation = opperation;
    }

    public History(Long id, User performer, String information, Opperation opperation, LocalDateTime creationDate) {
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
