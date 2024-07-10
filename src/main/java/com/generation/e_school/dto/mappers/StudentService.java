package com.generation.e_school.dto.mappers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.StudentDTOwGrades;
import com.generation.e_school.model.Student;

@Service
public class StudentService 
{
    @Autowired
    GradeService ser;

    private StudentMapper mapper = StudentMapper.ISTANCE;

    public Student toEntity(StudentDTO dto)
    {
        return mapper.toEntity(dto);
    }

    public List<Student> toEntity(List<StudentDTO> dtos)
    {
        List<Student> res = new ArrayList<>();

        for(StudentDTO dto:dtos)
            res.add(mapper.toEntity(dto));

        return res;
    }

    public StudentDTO toDTO(Student s)
    {
        return mapper.toDTO(s);
    }

    public List<StudentDTO> toDTO(List<Student> students)
    {
        List<StudentDTO> res = new ArrayList<>();

        for(Student s:students)
            res.add(mapper.toDTO(s));

        return res;
    }

    public StudentDTOwGrades toDTOwGrades(Student s)
    {
        //1 creo un dto con voti a partire da un dto senza
        StudentDTOwGrades res = new StudentDTOwGrades(toDTO(s));
        //2 converto i voti dello studente in dto di voti e li imposto
        res.setGrades(ser.toDTO(s.getGradesReceived()));
        
        return res;
    }

    public List<StudentDTOwGrades> toDTOwGrades(List<Student> students)
    {
        List<StudentDTOwGrades> res = new ArrayList<>();

        for(Student s:students)
            res.add(toDTOwGrades(s));

        return res;
    }
}
