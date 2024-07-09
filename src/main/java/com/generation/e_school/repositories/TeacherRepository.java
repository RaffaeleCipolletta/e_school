package com.generation.e_school.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.e_school.model.Teacher;


public interface TeacherRepository extends JpaRepository<Teacher,Integer>
{
    //metodo con query nominale
    Optional<Teacher> findByNameAndSurname(String name, String surname);
}
