package ru.dexsys.operations;

import ru.dexsys.connection.Connector;
import ru.dexsys.student.Student;
import ru.dexsys.student.StudentController;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Operations {
    private static String sqlStatement;
    private static Connection connection;
    private static Statement statement;
    private static final ArrayList<Student> students = StudentController.CreateListOfStudents();
    private static ResultSet rs;

    public static void showStudentTable() throws SQLException {
        connection = Connector.getConnection();
        sqlStatement = "SELECT * FROM Students;";
        statement = connection.createStatement();
        rs = statement.executeQuery(sqlStatement);
        System.out.printf("%10s %10s %10s %10s", "Student_Id", "FirstName", "LastName", "Age\n");
        while (rs.next()) {
            System.out.printf(
                    "%10d %10s %10s %8d",
                    rs.getInt("Student_Id"),
                    rs.getString("First_Name"),
                    rs.getString("Last_Name"),
                    rs.getInt("Age")
            );
            System.out.println();
        }
        connection.close();
    }

    public static void createStudentTable() throws SQLException {
        connection = Connector.getConnection();
        sqlStatement = "CREATE TABLE students" +
                       "(Student_Id SERIAL PRIMARY KEY," +
                       "First_Name varchar(20)," +
                       "Last_Name varchar(20)," +
                       "Age int);";
        statement = connection.createStatement();
        statement.execute(sqlStatement);
        System.out.println("Table \"students\" was created!");
        connection.close();
    }

    public static void insertStudentTable(String firstName, String lastName, int age) throws  SQLException {
        connection = Connector.getConnection();
        sqlStatement = "SELECT * "
                    + "FROM Students "
                    + "WHERE first_name='" + firstName + "' AND "
                    + "last_name='" + lastName + "' AND "
                    + "age=" + age + ";";
        statement = connection.createStatement();
        rs = statement.executeQuery(sqlStatement);
        if(!rs.next()) {
            sqlStatement = "INSERT INTO Students "
                        + "(first_name, last_name, age) VALUES "
                        + "('" + firstName + "','"
                        + lastName + "',"
                        + age + ");";
            statement = connection.createStatement();
            statement.execute(sqlStatement);
        }else{
            System.out.println("Found match in table");
        }
        connection.close();
    }

    public static void fillStudentTable() throws SQLException {
        connection = Connector.getConnection();
        for (Student s : students) {
            sqlStatement = "INSERT INTO Students"
                    + "(first_name, last_name, age) VALUES"
                    + "('" + s.getFirstName() + "','"
                    + s.getLastName() + "',"
                    + s.getAge() + ");";
            statement = connection.createStatement();
            statement.execute(sqlStatement);
        }
        connection.close();
    }

    public static void dropStudentTable() throws SQLException {
        connection = Connector.getConnection();
        sqlStatement = "DROP TABLE students;";
        statement = connection.createStatement();
        statement.execute(sqlStatement);
        System.out.println("Table students was dropped!");
    }
}
