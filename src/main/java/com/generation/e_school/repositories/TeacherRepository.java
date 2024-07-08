package com.generation.e_school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.e_school.model.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{

}
