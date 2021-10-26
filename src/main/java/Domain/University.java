package Domain;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class University {

    private final String name;

    private final List<Department> departments;

    public University(String name, List<Department> departments) {
        this.name = name;
        this.departments = departments;
    }

    public String getName() {
        return name;
    }

    public List<Department> getDepartments() {
        return departments;
    }

    public List<String> getAllStudentFullNamesByAge(int age) {
        return getAllStudentByPredicate(s -> s.getAge() >= age);
    }

    public List<String> getAllStudentByPredicate(Predicate<Student> studentPredicate) {
        return departments.stream()
                .flatMap(dep -> dep.getStudents().stream())
                .filter(studentPredicate)
                .map(Student::getFullName)
                .collect(Collectors.toList());
    }
}
