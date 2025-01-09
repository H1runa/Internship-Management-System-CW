package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class ApplicationDAO {
    private Connection conn; 
    
    public ApplicationDAO(){
        this.conn = DBConnection.getConnection();
    }
    
    public void addApplication(Application appl) throws SQLException{
        String query = "INSERT INTO Applications (stu_id, internship_id, date, resume, status) VALUES (?, ?, ?, ?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            
            prp.setInt(1, appl.getStu_id());
            prp.setInt(2, appl.getInternship_id());
            prp.setString(3, appl.getDate());
            prp.setString(4, appl.getResume());
            prp.setString(5, appl.getStatus());
            
            prp.executeUpdate();
            System.out.println("Application added to database.");
        }
    }
    
    public Application getApplicationByID(int id) throws SQLException{
        String query = "SELECT * FROM Applications WHERE application_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    Application appl = new Application(rs.getInt("application_id"), rs.getInt("stu_id"),rs.getInt("internship_id") ,rs.getString("date"), rs.getString("resume"), rs.getString("status"));
                    return appl;
                }
                else{
                    throw new SQLException("Null returned");
                }
            }
        }
        
    }
    
    public List<Application> getApplications() throws SQLException{
        String query = "SELECT * FROM Applications";
        List<Application> appls = new ArrayList<Application>();
        
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){            
            
            while (rs.next()){
                Application appl = new Application(rs.getInt("application_id"), rs.getInt("stu_id"),rs.getInt("internship_id") ,rs.getString("date"), rs.getString("resume"), rs.getString("status"));
                appls.add(appl);
            }
            
            System.out.println("Applications list retrieved.");
            return appls;
                
            
        }
        
    }
    
    public void updateApplication(Application appl) throws SQLException{
        String query = "UPDATE Applications SET stu_id = ? , internship_id = ? , date = ?, resume = ?, status = ?  WHERE application_id = ?";
        
        try (PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, appl.getStu_id());
            prp.setInt(2, appl.getInternship_id());
            prp.setString(3, appl.getDate());
            prp.setString(4, appl.getResume());
            prp.setString(5, appl.getStatus());
            prp.setInt(6, appl.getApplication_id());
            
            int rows_affected = prp.executeUpdate();
            if(rows_affected > 0){
                System.out.println("Application updated.");
            } else {
                throw new SQLException("ID not found");
            }
        }
    }
    
    public void deleteApplication(int id) throws SQLException{
        String query = "DELETE FROM Applications WHERE application_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            int rows_affected = prp.executeUpdate();
            if (rows_affected > 0){
                System.out.println("Application deleted.");
            } else {
                throw new SQLException("ID not found");
            }
            
        }
    }
    
    public void deleteAll() throws SQLException{
        String query = "DELETE FROM Applications";
        
        try(Statement stmt = conn.createStatement()){
            stmt.executeUpdate(query);
            System.out.println("All Application records deleted.");
        }
    }
    
    public int getApplicationsSubmitted(int id) throws SQLException{
        String query = "SELECT COUNT(*) FROM Applications WHERE stu_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            try (ResultSet rs = prp.executeQuery()){
                if(rs.next()){
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }
    
    public int getApplicationsAccepted(int id) throws SQLException{
        String query = "SELECT COUNT(*) FROM Applications WHERE stu_id = ? AND status = 'Accepted'";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            try (ResultSet rs = prp.executeQuery()){
                if(rs.next()){
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }
    
    public int getApplicationsRejected(int id) throws SQLException{
        String query = "SELECT COUNT(*) FROM Applications WHERE stu_id = ? AND status = 'Rejected'";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            try (ResultSet rs = prp.executeQuery()){
                if(rs.next()){
                    return rs.getInt(1);
                }
            }
        }
        return 0;
    }
    
}
