package com.generation.e_school.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Grade extends BaseEntity
{
    private String subject;
    private LocalDate day;
    private Double value;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "student_id",nullable = false)
    private Student student;//riferimento al padre
    
    @ManyToOne
    @JoinColumn(name = "teacher_id",nullable = false)
    private Teacher teacher;


   

}
