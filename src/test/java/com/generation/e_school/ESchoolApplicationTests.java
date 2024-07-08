package com.generation.e_school;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

		Student s = new Student();
		s.setName("Stefano");
		s.setSurname("Rubinetti");
		s.setEmail("no");
		s.setDob(LocalDate.of(1995, 8, 27));
		s.setClassRoom("5A");

		sRepo.save(s);

		Teacher t = new Teacher();
		t.setName("Estaban");
		t.setSurname("Rubinettis");
		t.setEmail("no");
		t.setDob(LocalDate.of(1990, 8, 27));
		t.setSubject("JAVA");

		tRepo.save(t);
	}

}
