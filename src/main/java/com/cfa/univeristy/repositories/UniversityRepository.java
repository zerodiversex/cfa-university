package com.cfa.univeristy.repositories;

import com.cfa.univeristy.models.University;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UniversityRepository extends JpaRepository<University, Long> {
}
