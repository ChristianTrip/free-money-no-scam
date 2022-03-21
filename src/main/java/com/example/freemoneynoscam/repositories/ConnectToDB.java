package com.example.freemoneynoscam.repositories;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import java.sql.*;

public class ConnectToDB {


    static Statement statement;
    static ResultSet rs;
    static String sqlString;
    static Connection connection;


    private static void connectToDB() {
        System.out.println("Start connection to database");
        try {
            //Define URL of database server for database
            //on the localhost with the default port number 3306.
            String url = "jdbc:mysql://localhost:3306/free_money";

            //Get a connection to the database for a user named root with password admin
            connection = DriverManager.getConnection(url, "Trip", "Password1234");

            //Display the URL and connection information
            System.out.println("URL: " + url);
            System.out.println("Connection: " + connection);


            //Get another statement object initialized as shown.
            statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);


        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void connectDB() {

        try
        {
            String url = "jdbc:mysql://localhost:3306/free_money";
            connection = DriverManager.getConnection(url,"Trip","Password1234");
            System.out.println("Ok, we have a connection.");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public static void insertObject(String email){

        connectToDB();

        sqlString = "INSERT INTO user_emails (`user_email`) VALUES ('" + email + "')";
        try {
            statement = connection.createStatement();
            statement.executeUpdate(sqlString);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}



