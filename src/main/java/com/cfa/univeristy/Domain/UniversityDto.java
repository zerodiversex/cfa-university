package com.cfa.univeristy.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class UniversityDto {

    private final String name;

    private final List<DepartmentDto> departments;


    public List<String> getAllStudentFullNamesByAge(int age) {
        return getAllStudentByPredicate(s -> s.getAge() >= age);
    }

    public List<String> getAllStudentByPredicate(Predicate<StudentDto> studentPredicate) {
        return departments.stream()
                .flatMap(dep -> dep.getStudents().stream())
                .filter(studentPredicate)
                .map(StudentDto::getFullName)
                .collect(Collectors.toList());
    }
}
