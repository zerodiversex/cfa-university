package com.cfa.univeristy.intergrations;

import com.cfa.univeristy.models.Department;
import com.cfa.univeristy.models.Student;
import com.cfa.univeristy.models.University;
import com.cfa.univeristy.repositories.DepartmentRepository;
import com.cfa.univeristy.repositories.StudentRepository;
import com.cfa.univeristy.repositories.UniversityRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UniversityIntegrationTest {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Test
    public void testGetAllStudentsNameByAgeGreaterOrEqualTo22() {

        University university = University.builder().name("CFA INSTA").departments(new ArrayList<>()).build();

        Department department = Department.builder().students(new ArrayList<>()).build();

        university.getDepartments().add(department);

        universityRepository.save(university);

        //departmentRepository.save(department);

        Student student1 = Student.builder().firstName("Toan").lastName("Tran").age(26).department(department).build();
        Student student2 = Student.builder().firstName("Quan").lastName("Nguyen").age(24).department(department).build();
        Student student3 = Student.builder().firstName("Trung").lastName("Bui").age(24).department(department).build();

        department.getStudents().add(student1);
        department.getStudents().add(student2);
        department.getStudents().add(student3);

        departmentRepository.save(department);

        //studentRepository.save(student1);
        //studentRepository.save(student2);
        //studentRepository.save(student3);

        var universities = universityRepository.findAll();

        university = universities.get(0);

        assertThat(university.getAllStudentFullNamesByAge(24)).containsExactlyInAnyOrderElementsOf(Stream.of(student1, student2, student3).map(Student::getFullName).collect(Collectors.toList()));

        assertThat(university.getAllStudentFullNamesByAge(26)).containsExactlyInAnyOrderElementsOf(Stream.of(student1).map(Student::getFullName).collect(Collectors.toList()));

    }
}
