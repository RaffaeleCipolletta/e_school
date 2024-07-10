package com.generation.e_school.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.generation.e_school.dto.EntityNotFoundDTO;

@RestControllerAdvice
public class ControllersExceptionHandler 
{

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public EntityNotFoundDTO studentNotFoundExceptionHandler(StudentNotFoundException e)
    {
        EntityNotFoundDTO res = new EntityNotFoundDTO(e.getMessage(),"Student");
        return res;
    }

    @ExceptionHandler(TeacherNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public EntityNotFoundDTO teacherNotFoundExceptionHandler(TeacherNotFoundException e)
    {
        EntityNotFoundDTO res = new EntityNotFoundDTO(e.getMessage(),"Teacher");
        return res;
    }
}
