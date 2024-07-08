package com.generation.e_school;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.mappers.StudentMapper;
import com.generation.e_school.model.Student;
import com.generation.e_school.model.Teacher;
import com.generation.e_school.repositories.PersonRepository;
import com.generation.e_school.repositories.StudentRepository;
import com.generation.e_school.repositories.TeacherRepository;


@SpringBootTest
class ESchoolApplicationTests 
{
	@Autowired
	PersonRepository pRepo;
	@Autowired
	StudentRepository sRepo;
	@Autowired
	TeacherRepository tRepo;


	@Test
	void contextLoads() 
	{

		Student s = sRepo.findById(1).get();
		
		StudentDTO dto = StudentMapper.ISTANCE.toDTO(s);

		assertEquals("s", s.toString());
	}

}
