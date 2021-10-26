package com.cfa.univeristy.repositories;

import com.cfa.univeristy.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
