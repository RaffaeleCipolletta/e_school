package com.generation.e_school.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.model.Student;

@Mapper
public interface StudentMapper 
{
    //Creare un singleton del Mapper
    public static final StudentMapper ISTANCE = Mappers.getMapper(StudentMapper.class);

    @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    StudentDTO toDTO(Student s);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(source = "dob",target = "dob", dateFormat = "yyyy-MM-dd")
    Student toEntity(StudentDTO dto);

}
