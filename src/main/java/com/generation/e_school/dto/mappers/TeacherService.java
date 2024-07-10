package com.generation.e_school.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.generation.e_school.dto.TeacherDTO;
import com.generation.e_school.dto.TeacherDTOwGrades;
import com.generation.e_school.model.Teacher;


@Service
public class TeacherService  
{
    @Autowired
    GradeService ser;


    private TeacherMapper mapper = TeacherMapper.ISTANCE;

    public Teacher toEntity(TeacherDTO dto)
    {
        return mapper.toEntity(dto);
    }

    public List<Teacher> toEntity(List<TeacherDTO> dtos)
    {
        List<Teacher> res = new ArrayList<>();

        for(TeacherDTO dto:dtos)
            res.add(mapper.toEntity(dto));

        return res;
    }

    public TeacherDTO toDTO(Teacher t)
    {
        return mapper.toDTO(t);
    }

    public List<TeacherDTO> toDTO(List<Teacher> teachers)
    {
        List<TeacherDTO> res = new ArrayList<>();

        for(Teacher t:teachers)
            res.add(mapper.toDTO(t));

        return res;
    }

    public TeacherDTOwGrades toDTOwGrades(Teacher t)
    {
        TeacherDTOwGrades res = new TeacherDTOwGrades(toDTO(t));

        res.setGrades(ser.toDTO(t.getGradesGiven()));

        return res;
    }

    public List<TeacherDTOwGrades> toDTOwGrades(List<Teacher> teachers)
    {
        List<TeacherDTOwGrades> res = new ArrayList<>();

        for (Teacher t : teachers) 
        {
            res.add(toDTOwGrades(t));            
        }
        return res;
    }

}
