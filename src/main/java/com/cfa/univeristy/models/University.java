package com.cfa.univeristy.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany
    private List<Department> departments;

    @Transient
    public List<String> getAllStudentFullNamesByAge(int age) {
        return getAllStudentByPredicate(s -> s.getAge() >= age);
    }

    @Transient
    public List<String> getAllStudentByPredicate(Predicate<Student> studentPredicate) {
        return departments.stream()
                .flatMap(dep -> dep.getStudents().stream())
                .filter(studentPredicate)
                .map(Student::getFullName)
                .collect(Collectors.toList());
    }
}
