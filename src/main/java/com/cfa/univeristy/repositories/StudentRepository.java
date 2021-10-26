package com.cfa.univeristy.repositories;

import com.cfa.univeristy.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findStudentByFirstName(String firstName);
}
