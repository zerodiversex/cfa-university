package com.cfa.univeristy.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class DepartmentDto {
    private final String name;

    private final List<StudentDto> students;
}
