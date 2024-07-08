package com.generation.e_school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.e_school.dto.TeacherDTO;
import com.generation.e_school.dto.mappers.TeacherService;
import com.generation.e_school.model.Teacher;
import com.generation.e_school.repositories.TeacherRepository;

@RestController
@RequestMapping("teachers")
public class TeacherController 
{

    @Autowired
    TeacherRepository repo;
    @Autowired
    TeacherService ser;

    @GetMapping
    public List<TeacherDTO> getAll() 
    {
        return ser.toDTO(repo.findAll());
    }
    

    @PostMapping
    public TeacherDTO insertNewTeacher(@RequestBody TeacherDTO dto) 
    {
        Teacher t = ser.toEntity(dto);

        t =repo.save(t);

        return ser.toDTO(t);
    }
    
}