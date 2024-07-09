package com.generation.e_school.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TeacherDTO extends PersonDTO
{
    private String subject;
    
}
