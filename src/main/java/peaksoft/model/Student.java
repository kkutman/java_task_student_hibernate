package peaksoft.model;

import lombok.Getter;
import lombok.Setter;

/**
 * name : kutman
 **/
@Getter
@Setter
public class Student {
    private Long id;
    private String firstName;
    private String lastName;
    private int age;

    public Student(Long id, String firstName, String lastName, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Student() {
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                "\n";
    }
}
