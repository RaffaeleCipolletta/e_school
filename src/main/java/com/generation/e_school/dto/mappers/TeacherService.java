package com.generation.e_school.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.e_school.dto.TeacherDTO;
import com.generation.e_school.model.Teacher;


@Service
public class TeacherService 
{
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

}
