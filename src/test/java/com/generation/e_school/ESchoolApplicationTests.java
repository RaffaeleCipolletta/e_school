package com.generation.e_school;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.generation.e_school.dto.StudentDTO;
import com.generation.e_school.dto.mappers.StudentMapper;
import com.generation.e_school.model.Grade;
import com.generation.e_school.model.Student;
import com.generation.e_school.model.Teacher;
import com.generation.e_school.repositories.GradeRepository;
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
	@Autowired
	GradeRepository gRepo;


	@Test
	void contextLoads() 
	{

		Student s = sRepo.findById(1).get();
		Teacher t = tRepo.findById(2).get();

		Grade g1 = new Grade();
		g1.setDay(LocalDate.now().minusDays(10));
		g1.setSubject("CSS");
		g1.setValue(6.5);
		g1.setStudent(s);
		g1.setTeacher(t);

		Grade g2 = new Grade();
		g2.setDay(LocalDate.now().minusDays(10));
		g2.setSubject("JAVA");
		g2.setValue(9.5);
		g2.setStudent(s);
		g2.setTeacher(t);

		gRepo.save(g1);
		gRepo.save(g2);


	}

}
