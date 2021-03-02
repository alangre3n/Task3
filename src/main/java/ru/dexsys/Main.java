package ru.dexsys;

import ru.dexsys.operations.Operations;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class Main {

    //private static final String USER_NAME = "postgres";
    //private static final String PASSWORD = "1993909";
    //private static final String URL = "jdbc:postgresql://localhost:5432/postgresdb";


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
