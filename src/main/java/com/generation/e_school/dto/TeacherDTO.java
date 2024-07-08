package com.generation.e_school.dto;

import com.generation.e_school.model.Person;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class TeacherDTO extends Person
{
    private String subject;
    
}
