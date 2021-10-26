<<<<<<< HEAD:src/test/java/com/cfa/univeristy/models/StudentTest.java
package com.cfa.univeristy.models;
=======
package com.cfa.univeristy.domain;
>>>>>>> db7f3b439d7644df4b07b92a35379af1159ef0e4:src/test/java/com/cfa/univeristy/domain/StudentTest.java

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Test Student Class")
class StudentTest {

    @DisplayName("Test getFullName(), expected OK")
    @ParameterizedTest
    @CsvSource({"Tran,Toan,Tran.Toan", "Messi,Lionel,Messi.Lionel", "Baba,Yaga,Baba.Yaga", "'','',."})
    public void shouldReturnFullName(String firstName, String lastName, String expected) {
        //Given
        Student student = new Student(1L, firstName, lastName, 26);
        //When
        String fullName = student.getFullName();
        //Then
        assertEquals(expected, fullName);
    }
}