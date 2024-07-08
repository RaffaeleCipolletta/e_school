package com.generation.e_school.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.e_school.model.Person;

public interface PersonRepository extends JpaRepository<Person,Integer>
{

}
