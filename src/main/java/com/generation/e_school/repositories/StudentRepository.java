package com.generation.e_school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.e_school.model.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>
 {

}
