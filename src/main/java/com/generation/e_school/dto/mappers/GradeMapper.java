package com.generation.e_school.dto.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.generation.e_school.dto.GradeDTO;
import com.generation.e_school.model.Grade;
@Mapper
public interface GradeMapper 
{
    public static final GradeMapper ISTANCE = Mappers.getMapper(GradeMapper.class);

    @Mapping(source = "day",target = "day", dateFormat = "yyyy-MM-dd")
    @Mapping(source = "student.id",target = "student_id")
    @Mapping(source = "teacher.id",target = "teacher_id")
    @Mapping(source = "student.name",target = "studentName")
    @Mapping(source = "student.surname",target = "studentSurname")
    @Mapping(source = "teacher.name",target = "teacherName")
    @Mapping(source = "teacher.surname",target = "teacherSurname")
    GradeDTO toDTO(Grade s);

    @Mapping(target = "createdDate", ignore = true)
    @Mapping(target = "lastModifiedDate", ignore = true)
    @Mapping(source = "day",target = "day", dateFormat = "yyyy-MM-dd")
    @Mapping(target = "student", ignore = true)
    @Mapping(target = "teacher", ignore = true)
    Grade toEntity(GradeDTO dto);
}
