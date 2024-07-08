package com.generation.e_school.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PersonDTO 
{
    protected Integer id;
    protected String name,surname;
    protected String dob;
    protected String email;
}
