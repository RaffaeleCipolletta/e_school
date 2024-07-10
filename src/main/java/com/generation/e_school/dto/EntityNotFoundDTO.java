package com.generation.e_school.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EntityNotFoundDTO 
{
    private String message;
    private String entityType;
}
