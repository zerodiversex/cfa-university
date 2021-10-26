package com.cfa.univeristy.Domain;

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
        StudentDto stud1 = new StudentDto("T","Q",23);
        DepartmentDto dept1 = new DepartmentDto("Paris",List.of(stud1));

        StudentDto stud2 = new StudentDto("Tran","Toan",22);
        DepartmentDto dept2 = new DepartmentDto("Lille",List.of(stud2));

        UniversityDto university = new UniversityDto("CFA Insta", List.of(dept1, dept2));

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
        Predicate<StudentDto> studentPredicate = stud -> stud.getAge() >= 22;

        StudentDto stud1 = new StudentDto("T","Q",age);
        DepartmentDto dept1 = new DepartmentDto("Paris",List.of(stud1));

        StudentDto stud2 = new StudentDto("Tran","Toan",age);
        DepartmentDto dept2 = new DepartmentDto("Lille",List.of(stud2));

        UniversityDto university = new UniversityDto("CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q", "Tran.Toan");
    }

    @DisplayName("Test getAllStudentByPredicate() Age is smaller than 18, expected OK")
    @Test
    public void shouldReturnStudentFullNamesWithPredicateAgeSmaller18() {
        //Given
        Predicate<StudentDto> studentPredicate = stud -> stud.getAge() <= 18;

        StudentDto stud1 = new StudentDto("T","Q",18);
        DepartmentDto dept1 = new DepartmentDto("Paris",List.of(stud1));

        StudentDto stud2 = new StudentDto("Tran","Toan",22);
        DepartmentDto dept2 = new DepartmentDto("Lille",List.of(stud2));

        UniversityDto university = new UniversityDto("CFA Insta", List.of(dept1, dept2));

        //When
        List<String> studentFullNames = university.getAllStudentByPredicate(studentPredicate);
        //Then
        assertThat(studentFullNames).containsExactly("T.Q");
    }
}
