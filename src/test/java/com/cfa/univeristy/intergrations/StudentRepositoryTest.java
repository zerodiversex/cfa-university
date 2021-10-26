package com.cfa.univeristy.intergrations;

import com.cfa.univeristy.models.Student;
import com.cfa.univeristy.repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void testFindByName_WillReturnTheExactResult() {

        entityManager.persist(new Student(1L, "Toan","Tran", 26));
        entityManager.persist(new Student(2L, "Quan", "Nguyen", 24));
        entityManager.persist(new Student(3L, "Trung", "Bui", 24));

        var students = studentRepository.findAll();

        assertThat(students.size()).isEqualTo(3);

    }
}

