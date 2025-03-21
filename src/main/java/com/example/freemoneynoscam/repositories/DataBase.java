package com.example.freemoneynoscam.repositories;

import com.example.freemoneynoscam.models.Email;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;

public class DataBase {

    static Statement statement;
    static ResultSet resultSet;
    static String sqlString;
    static Connection connection;


    private static boolean connectToDB() {
        System.out.println("Start connection to database");
        String url = "jdbc:mysql://localhost:3306/free_money";
        try {

            connection = DriverManager.getConnection(url, "Trip", "Password1234");

            System.out.println("URL: " + url);
            System.out.println("Connection: " + connection);

            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        }
        catch (Exception e) {
            System.out.println("could not connect to database at " + url);
            return false;
        }

        return true;
    }


    public static void insertObject(String email){

        if (connectToDB()){

            sqlString = "INSERT INTO user_emails (`user_email`) VALUES ('" + email + "')";
            try {
                statement = connection.createStatement();
                statement.executeUpdate(sqlString);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            System.out.println("cannot update database");
        }

    }

    public static String viewData(){

        connectToDB();

        String toReturn = "";

        sqlString = "SELECT * FROM free_money.user_emails";

        try {
            resultSet = statement.executeQuery(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        System.out.println("Display all results:");
        System.out.println("\t|---------------------------------------------|");
        System.out.printf("\t| %-7s | %-33s |\n", "user_id", "user_email");
        System.out.println("\t|---------------------------------------------|");
        toReturn += "Display all results:\n" +
                    "\t|---------------------------------------------|\n" +
                    String.format("\t| %-7s | %-33s |\n", "user_id", "user_email\n") +
                    "\t|---------------------------------------------|\n";


        while(true) {

            try {
                if (!resultSet.next()) break;
                String col0 = resultSet.getString("user_id");
                String col1 = resultSet.getString("user_email");


                System.out.printf("\t| %-7s | %-33s |", col0, col1);
                toReturn += String.format("\t| %-7s | %-33s |", col0, col1);
                System.out.println();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//end while loop
        System.out.println("\t|---------------------------------------------|");
        toReturn += "\t|---------------------------------------------|";

        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return toReturn;
    }

    public static ArrayList<Email> getEmails(){
        connectToDB();

        ArrayList<Email> emails = new ArrayList<>();

        sqlString = "SELECT * FROM free_money.user_emails";

        try {
            resultSet = statement.executeQuery(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        while(true) {

            try {
                if (!resultSet.next()) break;
                String col0 = resultSet.getString("user_id");
                String col1 = resultSet.getString("user_email");


                emails.add(new Email(Integer.valueOf(col0), col1));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }//end while loop


        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return emails;
    }


 }





