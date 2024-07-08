package com.generation.e_school.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StudentDTOwGrades extends StudentDTO
{
    public StudentDTOwGrades(StudentDTO dto)
    {
        this.id = dto.id;
        this.dob = dto.dob;
        this.email = dto.email;
        this.name = dto.name;
        this.classRoom = dto.classRoom;
        this.surname = dto.surname;
    }

    private List<GradeDTO> grades;
}
