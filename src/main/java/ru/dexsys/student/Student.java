package ru.dexsys.student;

import lombok.*;

@Getter
@Setter
@ToString
public class Student {
    private int studentId;
    private String firstName;
    private String lastName;
    private int age;
    private int counter;

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.studentId = ++counter;
    }

    public Student() {
        this.firstName = null;
        this.lastName = null;
        this.age = 0;
        this.studentId=++counter;
    }
}
