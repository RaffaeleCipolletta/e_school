package com.generation.e_school.dto;

import com.generation.e_school.model.Student;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class StudentDTO extends PersonDTO
{

    protected String classRoom;

}
