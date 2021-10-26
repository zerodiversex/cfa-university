package com.cfa.univeristy.repositories;

import com.cfa.univeristy.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}
