package ru.dexsys;

import ru.dexsys.operations.Operations;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Operations.createStudentTable();
        Operations.fillStudentTable();
        Operations.showStudentTable();
        Operations.insertStudentTable("Pavel","Fillipov", 21);
        Operations.insertStudentTable("Ekaterina","Sadakova", 23);
        Operations.insertStudentTable("Ivan","Petrov", 28);
        Operations.insertStudentTable("Oleg","Lukin", 20);
        Operations.showStudentTable();
        Operations.dropStudentTable();
    }
}
