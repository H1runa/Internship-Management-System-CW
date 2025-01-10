package com.mycompany.internshipmanager;

import java.sql.*;


public class DBConnection{
    private static final String dbpath = "database/internships.db";
    private static volatile Connection conn = null; //volatile keyword ensures better thread safety
    
    private DBConnection(){}; 
    
    public static Connection getConnection(){
        if (conn == null){ //this ensures the program doesnt sync the threads for no reason
            synchronized(DBConnection.class){
                if (conn == null){
                    try{
                        conn = DriverManager.getConnection("jdbc:sqlite:"+dbpath);
                        Statement stmt = conn.createStatement();
                        
                        stmt.executeUpdate("PRAGMA foreign_keys = ON;"); //enabling the foreign key constraint. no it doesnt enable by default apparently
                        
                        System.out.println("Database connection retrieved.");
                    } catch (SQLException ex){
                        System.out.println("Database connection could not be retrieved: "+ex.getMessage());
                    }
                }
            }
        }
        return conn;
    }
    
    public static void closeConnection(){
        try{
            if (conn == null || conn.isClosed()){
                System.out.println("No open connection found");
                return;
            }
        
            conn.close();
            System.out.println("Database closed.");
            
        } catch (SQLException ex){
            System.out.println("Database could not be closed : "+ ex.getMessage());
        }
    }
}
