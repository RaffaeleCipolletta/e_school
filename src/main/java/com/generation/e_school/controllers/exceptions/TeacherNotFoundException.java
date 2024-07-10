package com.generation.e_school.controllers.exceptions;

public class TeacherNotFoundException extends RuntimeException
{
    public TeacherNotFoundException(String message)
    {
        super(message);
    }
}
