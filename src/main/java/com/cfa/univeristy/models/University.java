package com.cfa.univeristy.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "university")
    private List<Department> departments = new ArrayList<>();

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
