package com.generation.e_school.model;


import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends Person
{
    private String classRoom;

}
