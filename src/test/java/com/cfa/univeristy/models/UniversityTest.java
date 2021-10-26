<<<<<<< HEAD:src/test/java/com/cfa/univeristy/models/UniversityTest.java
package com.cfa.univeristy.models;
=======
package com.cfa.univeristy.domain;
>>>>>>> db7f3b439d7644df4b07b92a35379af1159ef0e4:src/test/java/com/cfa/univeristy/domain/UniversityTest.java

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
        Student stud1 = new Student(1L, "T", "Q", 23);
        Department dept1 = new Department(1L, "Paris", List.of(stud1));

        Student stud2 = new Student(1L, "Tran", "Toan", 22);
        Department dept2 = new Department(1L, "Lille", List.of(stud2));

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentFullNamesByAge(age);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q", "Tran.Toan");
    }

    @DisplayName("Test getAllStudentByPredicate() Age is greater then 22, expected OK")
    @ParameterizedTest
    @ValueSource(ints = {22, 23, 24, 25})
    public void shouldReturnStudentFullNamesWithPredicateAgeGreater22(int age) {
        //Given
        Predicate<Student> studentPredicate = stud -> stud.getAge() >= 22;

        Student stud1 = new Student(1L, "T", "Q", age);
        Department dept1 = new Department(1L, "Paris", List.of(stud1));

        Student stud2 = new Student(1L, "Tran", "Toan", age);
        Department dept2 = new Department(1L, "Lille", List.of(stud2));

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q", "Tran.Toan");
    }

    @DisplayName("Test getAllStudentByPredicate() Age is smaller than 18, expected OK")
    @Test
    public void shouldReturnStudentFullNamesWithPredicateAgeSmaller18() {
        //Given
        Predicate<Student> studentPredicate = stud -> stud.getAge() <= 18;

        Student stud1 = new Student(1L, "T", "Q", 18);
        Department dept1 = new Department(1L, "Paris", List.of(stud1));

        Student stud2 = new Student(1L, "Tran", "Toan", 22);
        Department dept2 = new Department(1L, "Lille", List.of(stud2));

        University university = new University(1L, "CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q");
    }
}
