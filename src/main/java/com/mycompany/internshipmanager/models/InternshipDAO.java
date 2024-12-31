package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class InternshipDAO {
    private Connection conn;
    
    public InternshipDAO(){
        this.conn = DBConnection.getConnection();
    }
    
    public void addInternship(Internship intern) throws SQLException{
        String query = "INSERT INTO Internships (title, description, emp_id, duration, status) VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            
            
            prp.setString(1, intern.getTitle());
            prp.setString(2, intern.getDescription());
            prp.setInt(3, intern.getEmp_id());
            prp.setInt(4, intern.getDuration());
            prp.setString(5, intern.getStatus());
            
            prp.executeUpdate();
            System.out.println("Internship added to database.");
        }
    }
    
    public Internship getInternshipByID(int id) throws SQLException{
        String query = "SELECT * FROM Internships WHERE internship_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    Internship intern = new Internship(rs.getInt("internship_id"), rs.getString("title"), rs.getString("description"), rs.getInt("emp_id"), rs.getInt("duration"), rs.getString("status"));
                    return intern;
                }
                else{
                    throw new SQLException("Null returned");
                }
            }
        }
        
    }
    
    public List<Internship> getInternships() throws SQLException{
        String query = "SELECT * FROM Internships";
        List<Internship> interns = new ArrayList<Internship>();
        
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){            
            
            while (rs.next()){
                Internship intern = new Internship(rs.getInt("internship_id"), rs.getString("title"), rs.getString("description"), rs.getInt("emp_id"), rs.getInt("duration"), rs.getString("status"));
                interns.add(intern);
            }
            
            System.out.println("Internships list retrieved.");
            return interns;
                
            
        }
        
    }
    
    public void updateInternship(Internship intern) throws SQLException{
        String query = "UPDATE Internships SET title = ? , description = ? , emp_id = ?, duration = ?, status = ?  WHERE internship_id = ?";
        
        try (PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, intern.getTitle());
            prp.setString(2, intern.getDescription());
            prp.setInt(3, intern.getEmp_id());
            prp.setInt(4, intern.getDuration());
            prp.setString(5, intern.getStatus());
            prp.setInt(6, intern.getId());
            
            int rows_affected = prp.executeUpdate();
            if(rows_affected > 0){
                System.out.println("Internship updated.");
            } else {
                throw new SQLException("ID not found");
            }
        }
    }
    
    public void deleteInternship(int id) throws SQLException{
        String query = "DELETE FROM Internships WHERE internship_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            int rows_affected = prp.executeUpdate();
            if (rows_affected > 0){
                System.out.println("Internship deleted.");
            } else {
                throw new SQLException("ID not found");
            }
            
        }
    }
    
    public void deleteAll() throws SQLException{
        String query = "DELETE FROM Internships";
        
        try(Statement stmt = conn.createStatement()){
            stmt.executeUpdate(query);
            System.out.println("All Internship records deleted.");
        }
    }
    
}
