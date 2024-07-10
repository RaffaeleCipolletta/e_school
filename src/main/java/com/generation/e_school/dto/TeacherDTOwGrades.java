package com.generation.e_school.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TeacherDTOwGrades extends TeacherDTO
{
    public TeacherDTOwGrades(TeacherDTO dto)
    {
        this.id = dto.id;
        this.dob = dto.dob;
        this.email = dto.email;
        this.name = dto.name;
        this.surname = dto.surname;
        this.subject = dto.subject;
    }

    private List<GradeDTO> grades;
}
