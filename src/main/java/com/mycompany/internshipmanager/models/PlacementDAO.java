package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PlacementDAO {
    Connection conn;
    
    public PlacementDAO(){
        this.conn = DBConnection.getConnection();
    }
    
     public void addPlacement(Placement pla) throws SQLException{
        String query = "INSERT INTO Placements (std_id, internship_id, emp_id, status, start_date, end_date, feedback) VALUES (?, ?, ?, ?, ?, ?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            
            prp.setInt(1, pla.getStd_id());
            prp.setInt(2, pla.getInternship_id());
            prp.setInt(3, pla.getEmp_id());
            prp.setString(4, pla.getStatus());
            prp.setString(5, pla.getStart_date());
            prp.setString(6, pla.getEnd_date());
            prp.setString(7, pla.getFeedback());
            
            prp.executeUpdate();
            System.out.println("Placement added to database.");
        }
    }
    
    public Placement getPlacementByID(int id) throws SQLException{
        String query = "SELECT * FROM Placements WHERE placement_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    Placement pla = new Placement(rs.getInt("placement_id"), rs.getInt("std_id"),rs.getInt("internship_id") ,rs.getInt("emp_id"), rs.getString("status"), rs.getString("start_date"), rs.getString("end_date"), rs.getString("feedback"));
                    return pla;
                }
                else{
                    throw new SQLException("Null returned");
                }
            }
        }
        
    }
    
    public List<Placement> getPlacements() throws SQLException{
        String query = "SELECT * FROM Placements";
        List<Placement> plas = new ArrayList<Placement>();
        
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){            
            
            while (rs.next()){
                Placement pla = new Placement(rs.getInt("placement_id"), rs.getInt("std_id"),rs.getInt("internship_id") ,rs.getInt("emp_id"), rs.getString("status"), rs.getString("start_date"), rs.getString("end_date"), rs.getString("feedback"));
                plas.add(pla);
            }
            
            System.out.println("Placements list retrieved.");
            return plas;
                
            
        }
        
    }
    
    public void updatePlacement(Placement pla) throws SQLException{
        String query = "UPDATE Placements SET std_id = ? , internship_id = ? , emp_id = ?, status = ?, start_date = ?, end_date = ?, feedback = ?  WHERE placement_id = ?";
        
        try (PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, pla.getStd_id());
            prp.setInt(2, pla.getInternship_id());
            prp.setInt(3, pla.getEmp_id());
            prp.setString(4, pla.getStatus());
            prp.setString(5, pla.getStart_date());
            prp.setString(6, pla.getEnd_date());
            prp.setString(7, pla.getFeedback());
            prp.setInt(8, pla.getPlacement_id());
            
            int rows_affected = prp.executeUpdate();
            if(rows_affected > 0){
                System.out.println("Placement updated.");
            } else {
                throw new SQLException("ID not found");
            }
        }
    }
    
    public void deletePlacement(int id) throws SQLException{
        String query = "DELETE FROM Placements WHERE placement_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            int rows_affected = prp.executeUpdate();
            if (rows_affected > 0){
                System.out.println("Placement deleted.");
            } else {
                throw new SQLException("ID not found");
            }
            
        }
    }
    
    public void deleteAll() throws SQLException{
        String query = "DELETE FROM Placements";
        
        try(Statement stmt = conn.createStatement()){
            stmt.executeUpdate(query);
            System.out.println("All Placement records deleted.");
        }
    }
}
