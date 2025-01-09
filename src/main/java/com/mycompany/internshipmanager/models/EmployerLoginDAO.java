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
public class EmployerLoginDAO {
    private Connection conn;
    
    public EmployerLoginDAO(){
        this.conn = DBConnection.getConnection();
    }
    
    public void addEmployer(String email, String password) throws SQLException{
        String query = "INSERT INTO EmployerLogin(email, password) VALUES (?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, email);
            prp.setString(2, password);
            
            prp.executeUpdate();
            System.out.println("Employer Registered.");
        }
    }
    
    public void deleteEmployer(int id) throws SQLException{
        String query = "DELETE FROM EmployerLogin WHERE emp_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            prp.executeUpdate();
            System.out.println("Employer Login Deleted");
        }
    }
    
    public String getPasswordByEmail(String email) throws SQLException{
        String query = "SELECT password FROM EmployerLogin WHERE email = ?";
        
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
        String query = "SELECT emp_id FROM EmployerLogin WHERE email=?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, email);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    return rs.getInt("emp_id");
                }
            }
        }
        System.out.println("Incorrect PASS");
        throw new SQLException("Incorrect Password");
    }
            
    
    
}
