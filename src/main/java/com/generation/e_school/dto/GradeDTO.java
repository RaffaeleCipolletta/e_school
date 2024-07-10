package com.generation.e_school.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GradeDTO 
{
    private Integer id,student_id,teacher_id;
    private String subject;
    private String day;
    private Double value;
    private String studentName,studentSurname;
    private String teacherName,teacherSurname;
    

}
