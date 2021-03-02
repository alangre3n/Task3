package ru.dexsys.student;

import java.util.ArrayList;

public class StudentController {
    private static ArrayList<Student> students;

    public static ArrayList<Student> CreateListOfStudents() {
        students = new ArrayList<>();
        students.add(new Student("Pavel", "Fillipov", 21));
        students.add(new Student("Ivan", "Petrov", 28));
        students.add(new Student("Maksim", "Lukyanov", 23));
        students.add(new Student("Andrey", "Bazhenov", 18));
        students.add(new Student("Envgeniy", "Anisimov", 30));
        students.add(new Student("Oleg", "Lukin", 20));
        return students;
    }
}
