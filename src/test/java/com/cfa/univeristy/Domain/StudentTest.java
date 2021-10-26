package com.cfa.univeristy.Domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Student Class")
class StudentTest {

    @DisplayName("Test getFullName(), expected OK")
    @ParameterizedTest
    @CsvSource({"Tran,Toan,Tran.Toan", "Messi,Lionel,Messi.Lionel", "Baba,Yaga,Baba.Yaga", "'','',."})
    public void shouldReturnFullName(String firstName, String lastName, String expected) {
        //Given
        StudentDto student = new StudentDto(firstName, lastName, 26);
        //When
        String fullName = student.getFullName();
        //Then
        assertEquals(expected, fullName);
    }
}