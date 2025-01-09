package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Asus
 */
public class StudentLoginDAO {
    private Connection conn;
    
    public StudentLoginDAO(){
        this.conn = DBConnection.getConnection();
    }
    
    public void addStudent(String email, String password) throws SQLException{
        String query = "INSERT INTO StudentLogin(email, password) VALUES (?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, email);
            prp.setString(2, password);
            
            prp.executeUpdate();
            System.out.println("Student Registered.");
        }
    }
    
    public void deleteStudent(int id) throws SQLException{
        String query = "DELETE FROM StudentLogin WHERE std_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            prp.executeUpdate();
            System.out.println("Student Login Deleted");
        }
    }
    
    public String getPasswordByEmail(String email) throws SQLException{
        String query = "SELECT password FROM StudentLogin WHERE email = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, email);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    return rs.getString("password");
                }
            }
        }
        throw new SQLException("Incorrect Email");
    }
    
    public int getIdByEmail(String email) throws SQLException{
        String query = "SELECT std_id FROM StudentLogin WHERE email=?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, email);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    return rs.getInt("std_id");
                }
            }
        }
        System.out.println("Incorrect PASS");
        throw new SQLException("Incorrect Password");
    }
            
    
    
}
