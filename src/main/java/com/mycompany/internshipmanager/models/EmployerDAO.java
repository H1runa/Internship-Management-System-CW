package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.models.Employer;
import com.mycompany.internshipmanager.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployerDAO {
    private Connection conn;
    
    public EmployerDAO(){
        this.conn = DBConnection.getConnection();
    }
    
    public void addEmployer(Employer emp) throws SQLException{
        String query = "INSERT INTO Employers (name, email, phone) VALUES (?, ?, ?)";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            
            prp.setString(1, emp.getName());
            prp.setString(2, emp.getEmail());
            prp.setString(3, emp.getPhone());
            
            prp.executeUpdate();
            System.out.println("Employer added to database.");
        }
    }
    
    public Employer getEmployerByID(int id) throws SQLException{
        String query = "SELECT * FROM Employers WHERE emp_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            try(ResultSet rs = prp.executeQuery()){
                if (rs.next()){
                    Employer emp = new Employer(rs.getInt("emp_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
                    return emp;
                }
                else{
                    throw new SQLException("Null returned");
                }
            }
        }
        
    }
    
    public List<Employer> getEmployers() throws SQLException{
        String query = "SELECT * FROM Employers";
        List<Employer> emps = new ArrayList<Employer>();
        
        try(Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)){            
            
            while (rs.next()){
                Employer emp = new Employer(rs.getInt("emp_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
                emps.add(emp);
            }
            
            System.out.println("Employers list retrieved.");
            return emps;
                
            
        }
        
    }
    
    public void updateEmployer(Employer emp) throws SQLException{
        String query = "UPDATE Employers SET name = ? , email = ? , phone = ?  WHERE emp_id = ?";
        
        try (PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, emp.getName());
            prp.setString(2, emp.getEmail());
            prp.setString(3, emp.getPhone());
            prp.setInt(4, emp.getEmp_id());
            
            int rows_affected = prp.executeUpdate();
            if(rows_affected > 0){
                System.out.println("Employer updated.");
            } else {
                throw new SQLException("ID not found");
            }
        }
    }
    
    public void deleteEmployer(int id) throws SQLException{
        String query = "DELETE FROM Employers WHERE emp_id = ?";
        
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            
            int rows_affected = prp.executeUpdate();
            if (rows_affected > 0){
                System.out.println("Employer deleted.");
            } else {
                throw new SQLException("ID not found");
            }
            
        }
    }
    
    public void deleteAll() throws SQLException{
        String query = "DELETE FROM Employers";
        
        try(Statement stmt = conn.createStatement()){
            stmt.executeUpdate(query);
            System.out.println("All Employer records deleted.");
        }
    }
}
