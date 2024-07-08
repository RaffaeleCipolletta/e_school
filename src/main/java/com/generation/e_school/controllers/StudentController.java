package com.generation.e_school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.mappers.StudentMapper;
import com.generation.e_school.dto.mappers.StudentService;
import com.generation.e_school.model.Student;
import com.generation.e_school.repositories.StudentRepository;

import io.swagger.v3.oas.annotations.parameters.RequestBody;



@RestController
@RequestMapping("/students")
public class StudentController 
{

    @Autowired
    StudentRepository repo;
    @Autowired
    StudentService ser;

    @GetMapping
    public List<StudentDTO> getAll() 
    {
        // return  repo 
        //         .findAll()      //leggo da db tutti gli studenti
        //         .stream()       //li faccio diventare una stream per lavorarci
        //         .map(s -> StudentMapper.ISTANCE.toDTO(s)) //tramite il meto toDTO dello StudentMapper trasformo ogni studente nel suo DTO
        //         .toList();//riconverto in  lista

        return ser.toDTO(repo.findAll());
    }

    @PostMapping
    public StudentDTO insertNewStudent(@RequestBody StudentDTO dto)
    {
        Student s = ser.toEntity(dto);

        s = repo.save(s);

        return ser.toDTO(s);

    }
    

    //GET tutti
    //GET id singolo
    //POST singolo
    //UPDATE singolo
    //DELETE singolo



}
