package com.generation.e_school.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.e_school.controllers.exceptions.StudentNotFoundException;
import com.generation.e_school.controllers.exceptions.TeacherNotFoundException;
import com.generation.e_school.dto.GradeDTO;
import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.StudentDTOwGrades;
import com.generation.e_school.dto.mappers.GradeService;
import com.generation.e_school.dto.mappers.StudentService;
import com.generation.e_school.model.Grade;
import com.generation.e_school.model.Student;
import com.generation.e_school.model.Teacher;
import com.generation.e_school.repositories.GradeRepository;
import com.generation.e_school.repositories.StudentRepository;
import com.generation.e_school.repositories.TeacherRepository;




@RestController
@RequestMapping("/api/students")
public class StudentController 
{

    @Autowired
    StudentRepository sRepo;
    @Autowired
    StudentService sServ;
    @Autowired
    GradeService gServ;
    @Autowired
    TeacherRepository tRepo;
    @Autowired
    GradeRepository gRepo;

    @GetMapping
    public List<StudentDTO> getAll() 
    {
        // return  repo 
        //         .findAll()      //leggo da db tutti gli studenti
        //         .stream()       //li faccio diventare una stream per lavorarci
        //         .map(s -> StudentMapper.ISTANCE.toDTO(s)) //tramite il meto toDTO dello StudentMapper trasformo ogni studente nel suo DTO
        //         .toList();//riconverto in  lista

        return sServ.toDTO(sRepo.findAll());
    }

    @GetMapping("/{id}")
    public StudentDTOwGrades getOne(@PathVariable Integer id) 
    {

        return sServ.toDTOwGrades(sRepo.findById(id).get());
    }
    

    @PostMapping
    public StudentDTO insertNewStudent(@RequestBody StudentDTO dto) 
    {
        //Tramite @RequestBody Trasformo il JSON che mi arriva con la request in uno StudentDTO
        //Tramite il servizio del Mapper trasformo quel DTO in  una Entity
        Student s = sServ.toEntity(dto);

        //Che poi vado a salvare
        s = sRepo.save(s);

        //restituisco la entity come è stata salvata sotto forma di dto
        //che in automatico viene JSONizzato
        return sServ.toDTO(s);
    }
    
    // api/students/1/addgrade -> json del grade
    @PostMapping("/{idstudent}/addgrade")
    public GradeDTO addGrade(@RequestBody GradeDTO toSave,@PathVariable Integer idstudent) 
    {
        //1) converto il gradeDto in un Grade
        Grade g = gServ.toEntity(toSave);//è scollegata dallo studente e dal teacher padre
        //2) prendo lo studente padre tramite id
        Optional<Student> sPadre = sRepo.findById(idstudent);
        if(sPadre.isEmpty())
            throw new StudentNotFoundException("Student with id "+idstudent+" not found");

        //3) prendo il teacher padre tramite nome e cognome
        Optional<Teacher> tPadre = tRepo.findByNameAndSurname(toSave.getTeacherName(), toSave.getTeacherSurname());
        if(tPadre.isEmpty())
            throw new TeacherNotFoundException("Teacher with name "+toSave.getTeacherName()+" "+toSave.getTeacherSurname()+" not found");

        //4) li imposto come padri al grade
        g.setStudent(sPadre.get());
        g.setTeacher(tPadre.get());

        //salvo il grade
        g = gRepo.save(g);

        //restituisco il suo DTO al front-end
        return gServ.toDTO(g);
    }
    

    //GET tutti
    //GET id singolo
    //POST singolo
    //UPDATE singolo
    //DELETE singolo



}
