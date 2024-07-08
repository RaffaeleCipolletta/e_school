package com.generation.e_school.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public abstract class Person extends BaseEntity
{
    private String name,surname;
    private LocalDate dob;
    private String email;

}
