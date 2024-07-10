package com.generation.e_school.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.StudentDTOwGrades;
import com.generation.e_school.dto.mappers.StudentService;
import com.generation.e_school.model.Student;
import com.generation.e_school.repositories.StudentRepository;




@RestController
@RequestMapping("/api/students")
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

    @GetMapping("/{id}")
    public StudentDTOwGrades getOne(@PathVariable Integer id) 
    {

        return ser.toDTOwGrades(repo.findById(id).get());
    }
    

    @PostMapping
    public StudentDTO insertNewStudent(@RequestBody StudentDTO dto) 
    {
        //Tramite @RequestBody Trasformo il JSON che mi arriva con la request in uno StudentDTO
        //Tramite il servizio del Mapper trasformo quel DTO in  una Entity
        Student s = ser.toEntity(dto);

        //Che poi vado a salvare
        s = repo.save(s);

        //restituisco la entity come è stata salvata sotto forma di dto
        //che in automatico viene JSONizzato
        return ser.toDTO(s);
    }
    

    //GET tutti
    //GET id singolo
    //POST singolo
    //UPDATE singolo
    //DELETE singolo



}
