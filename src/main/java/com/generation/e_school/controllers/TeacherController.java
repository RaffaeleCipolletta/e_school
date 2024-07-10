package com.generation.e_school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.e_school.dto.StudentDTOwGrades;
import com.generation.e_school.dto.TeacherDTO;
import com.generation.e_school.dto.TeacherDTOwGrades;
import com.generation.e_school.dto.mappers.TeacherService;
import com.generation.e_school.model.Teacher;
import com.generation.e_school.repositories.TeacherRepository;


@RestController
@RequestMapping("/teachers")
public class TeacherController 
{

    @Autowired
    TeacherRepository repo;
    @Autowired
    TeacherService ser;

    @GetMapping
    public List<TeacherDTO> getAll() 
    {
        // return  repo 
        //         .findAll()      //leggo da db tutti gli studenti
        //         .stream()       //li faccio diventare una stream per lavorarci
        //         .map(s -> StudentMapper.ISTANCE.toDTO(s)) //tramite il meto toDTO dello StudentMapper trasformo ogni studente nel suo DTO
        //         .toList();//riconverto in  lista

        return ser.toDTO(repo.findAll());
    }
    
    @GetMapping("/{id}")
    public TeacherDTOwGrades getOne(@PathVariable Integer id)
    {

        return ser.toDTOwGrades(repo.findById(id).get());
    }

    @PostMapping
    public TeacherDTO insertNewTeacher(@RequestBody TeacherDTO dto) 
    {
        //Tramite @RequestBody Trasformo il JSON che mi arriva con la request in uno StudentDTO
        //Tramite il servizio del Mapper trasformo quel DTO in  una Entity
        Teacher t = ser.toEntity(dto);

        //Che poi vado a salvare
        t =repo.save(t);

        //restituisco la entity come è stata salvata sotto forma di dto
        //che in automatico viene JSONizzato
        return ser.toDTO(t);
    }
    
}
