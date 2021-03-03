package ru.dexsys;

import ru.dexsys.operations.Operations;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Operations.createStudentsTable();
        Operations.fillStudentsTable();
        Operations.showStudentsTable();
        Operations.insertIntoStudentsTable("Pavel","Fillipov", 21);
        Operations.insertIntoStudentsTable("Ekaterina","Sadakova", 23);
        Operations.insertIntoStudentsTable("Ivan","Petrov", 28);
        Operations.insertIntoStudentsTable("Oleg","Lukin", 20);
        Operations.showStudentsTable();
        Operations.dropStudentsTable();
    }
}
