package com.cfa.univeristy.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DisplayName("Test University Class")
public class UniversityTest {

    @DisplayName("Test getAllStudentFullNamesByAge(), expected OK")
    @ParameterizedTest
    @ValueSource(ints = {18, 19, 20, 21})
    public void shouldReturnStudentFullNamesWithAgeGreaterAgeParams(int age) {
        //Given
        Student stud1 = Student.builder().firstName("T").lastName("Q").age(23).build();
        Department dept1 = Department.builder().students(List.of(stud1)).build();

        Student stud2 = Student.builder().firstName("Toan").lastName("Tran").age(23).build();
        Department dept2 = Department.builder().students(List.of(stud2)).build();

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentFullNamesByAge(age);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q", "Toan.Tran");
    }

    @DisplayName("Test getAllStudentByPredicate() Age is greater then 22, expected OK")
    @ParameterizedTest
    @ValueSource(ints = {22, 23, 24, 25})
    public void shouldReturnStudentFullNamesWithPredicateAgeGreater22(int age) {
        //Given
        Predicate<Student> studentPredicate = stud -> stud.getAge() >= 22;

        Student stud1 = Student.builder().firstName("T").lastName("Q").age(age).build();
        Department dept1 = Department.builder().students(List.of(stud1)).build();

        Student stud2 = Student.builder().firstName("Toan").lastName("Tran").age(age).build();
        Department dept2 = Department.builder().students(List.of(stud2)).build();

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q", "Toan.Tran");
    }

    @DisplayName("Test getAllStudentByPredicate() Age is smaller than 18, expected OK")
    @Test
    public void shouldReturnStudentFullNamesWithPredicateAgeSmaller18() {
        //Given
        Predicate<Student> studentPredicate = stud -> stud.getAge() <= 18;

        Student stud1 = Student.builder().firstName("T").lastName("Q").age(18).build();
        Department dept1 = Department.builder().students(List.of(stud1)).build();

        Student stud2 = Student.builder().firstName("Toan").lastName("Tran").age(22).build();
        Department dept2 = Department.builder().students(List.of(stud2)).build();

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q");
    }

}
