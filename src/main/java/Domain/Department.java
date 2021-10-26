package Domain;

import java.util.List;

public class Department {
    private final String name;

    private final List<Student> students;

    public Department(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public String getName() {
        return name;
    }

    public List<Student> getStudents() {
        return students;
    }
}
