package com.cfa.univeristy.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class StudentDto {
    private final String firstName;

    private final String lastName;

    private final int age;

    public String getFullName() {
        return new StringBuilder(firstName).append(".").append(lastName).toString();
    }
}
