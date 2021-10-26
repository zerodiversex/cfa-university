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

        Student student1 = Student.builder().firstName("Toan").lastName("Tran").age(26).build();
        Student student2 = Student.builder().firstName("Quan").lastName("Nguyen").age(24).build();
        Student student3 = Student.builder().firstName("Trung").lastName("Bui").age(24).build();

        studentRepository.save(student1);
        studentRepository.save(student2);
        studentRepository.save(student3);

        var students = studentRepository.findStudentByFirstName("Toan");

        assertThat(students.size()).isEqualTo(1);

    }
}

