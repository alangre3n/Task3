package ru.dexsys;

import java.sql.*;
import java.util.ArrayList;

public class PostgreDB {

    private static final String USER_NAME = "postgres";
    private static final String PASSWORD = "12345";
    private static final String URL = "jdbc:postgresql://localhost:5432/students";
    private static ArrayList<String> students = new ArrayList<>();

    public static void main( String[] args )
    {
        insertIntoTable("Igor", "Melnikov", "Artemovich");
        insertIntoTable("Pavel", "Gimatov", "Andreevich");
        takeDataTable();
        insertIntoTable("Alan", "Gimatov", "Shamilevich");
        insertIntoTable("Alan", "Gimatov", "Shamilevich");
        printDataTable();
    }

    private static void printDataTable(){
        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)){
            System.out.println("Print all from table 'students'");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS");
            System.out.printf("%s %s %s", "FirstName", "LastName", "MiddleName\n");
            while(resultSet.next()){
                System.out.printf(
                        "%s %s %s",
                        resultSet.getString("FirstName"),
                        resultSet.getString("LastName"),
                        resultSet.getString("MiddleName")
                );
                System.out.println();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void takeDataTable() {
        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)){
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS");

            ResultSetMetaData rsmd = resultSet.getMetaData();
            int columnCount = rsmd.getColumnCount();

            students = new ArrayList<>(columnCount);
            while (resultSet.next()) {
                int i = 1;
                while(i <= columnCount) {
                    students.add(resultSet.getString(i++));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insertIntoTable(String firstName, String lastName, String middleName){
        try(Connection connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD)){
            System.out.println("Connection with database 'students'");
            Statement statement = connection.createStatement();

            int count=0;
            for(int i=0;i<students.size();i+=3) {
                if(students.get(i)==firstName && students.get(i+1) == lastName && students.get(i) == middleName) {
                    count=1;
                    break;
                }
            }
            if(count<1) {
                statement.execute(String.format(
                        "INSERT INTO STUDENTS VALUES(%s, %s, %s)",
                        firstName, lastName, middleName)
                );
                System.out.printf("row (%s, %s, %s) was added/n", firstName, lastName, middleName);
            }else{
                System.out.println("This student is already in the table");
                System.out.printf("%s %s %s", "firstName", "lastName", "middleName\n");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
