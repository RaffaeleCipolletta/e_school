package com.generation.e_school.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "created_date", nullable = false, updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime lastModifiedDate;

    @PrePersist           //questo metodo verrà richiamato in automatico quando salvo per la prima volta una entità
    public void onCreate()
    {
        createdDate         = LocalDateTime.now();
        lastModifiedDate    = LocalDateTime.now();
    }
    
    @PreUpdate
    public void onUpdate()
    {
        lastModifiedDate    = LocalDateTime.now();
    }


    
}
