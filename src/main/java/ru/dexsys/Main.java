package ru.dexsys;

import ru.dexsys.operations.Operations;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Operations.createStudentTable();
        Operations.fillStudentTable();
        Operations.showStudentTable();
        Operations.insertIntoStudentTable("Pavel","Fillipov", 21);
        Operations.insertIntoStudentTable("Ekaterina","Sadakova", 23);
        Operations.insertIntoStudentTable("Ivan","Petrov", 28);
        Operations.insertIntoStudentTable("Oleg","Lukin", 20);
        Operations.showStudentTable();
        Operations.dropStudentTable();
    }
}
