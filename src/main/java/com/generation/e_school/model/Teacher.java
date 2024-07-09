package com.generation.e_school.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper = true)
public class Teacher extends Person
{
    private String subject;
     @OneToMany(mappedBy = "teacher",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    private List<Grade> gradesGiven;
}
