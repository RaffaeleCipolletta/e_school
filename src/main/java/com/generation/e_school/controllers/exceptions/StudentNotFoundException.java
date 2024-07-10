package com.generation.e_school.controllers.exceptions;

public class StudentNotFoundException extends RuntimeException
{
    public StudentNotFoundException(String message)
    {
        super(message);
    }
}
