package com.generation.e_school.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.e_school.dto.TeacherDTO;
import com.generation.e_school.model.Teacher;

@Mapper
public interface TeacherMapper 
{

    public static final TeacherMapper ISTANCE = Mappers.getMapper(TeacherMapper.class);

    
    @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    TeacherDTO toDTO(Teacher t);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    Teacher toEntity(TeacherDTO dto);
}
