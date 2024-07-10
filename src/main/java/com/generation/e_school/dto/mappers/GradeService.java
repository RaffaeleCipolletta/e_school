package com.generation.e_school.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.generation.e_school.dto.GradeDTO;
import com.generation.e_school.model.Grade;
@Service
public class GradeService 
{
     private GradeMapper mapper = GradeMapper.ISTANCE;

    public Grade toEntity(GradeDTO dto)
    {
        return mapper.toEntity(dto);
    }

    public List<Grade> toEntity(List<GradeDTO> dtos)
    {
        List<Grade> res = new ArrayList<>();

        for(GradeDTO dto:dtos)
            res.add(mapper.toEntity(dto));

        return res;
    }

    public GradeDTO toDTO(Grade t)
    {
        return mapper.toDTO(t);
    }

    public List<GradeDTO> toDTO(List<Grade> Grades)
    {
        List<GradeDTO> res = new ArrayList<>();

        for(Grade t:Grades)
            res.add(mapper.toDTO(t));

        return res;
    }
}
