package Domain;

public class Student {
    private final String firstName;

    private final String lastName;

    private final int age;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return new StringBuilder(firstName).append(".").append(lastName).toString();
    }
}
