//DAO class for handling CRUD

package com.mycompany.internshipmanager.models;

import com.mycompany.internshipmanager.DBConnection;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

public class StudentDAO {
    private Connection conn;
    
    public StudentDAO(){
        this.conn  = DBConnection.getConnection();
    }
    
    public void addStudent(Student std) throws SQLException{
        String query = "INSERT INTO Students (first_name, last_name, dob, email, phone, department, yearOfStudy) VALUES (? , ? , ?, ?, ?, ?, ?)";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, std.getFirst_name());
            prp.setString(2, std.getLast_name());
            prp.setString(3, std.getDob());
            prp.setString(4, std.getEmail());
            prp.setString(5, std.getPhone());
            prp.setString(6, std.getDepartment());
            prp.setInt(7, std.getYearOfStudy());
            prp.executeUpdate();
            
            System.out.println("Added student.");
        } //no need for catch cuz we got try with resources
    }
    
    public List<Student> getStudents() throws SQLException{
        String query = "SELECT * FROM Students";
        List<Student> stdList = new ArrayList<Student>();
        try(Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                Student std = new Student(rs.getInt("std_id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("dob") , rs.getString("email"), rs.getString("phone"), rs.getString("department"),rs.getInt("yearOfStudy"));
                stdList.add(std);                
            }            
            System.out.println("Students list retrieved");
            return stdList;
            
        }
        
        
    }
    
    public Student getStudentByID(int id) throws SQLException{
        String query = "SELECT * FROM Students WHERE std_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query);){
            prp.setInt(1, id);
            //need another try cuz i have to use this one to set params. cant executeQuery in the try-resource above
            try(ResultSet rs = prp.executeQuery()){
                if(rs.next()){
                    Student std = new Student(rs.getInt("std_id"), rs.getString("first_name"),rs.getString("last_name"),rs.getString("dob") , rs.getString("email"), rs.getString("phone"), rs.getString("department"),rs.getInt("yearOfStudy"));
                    System.out.println("Student details retrieved.");
                    return std;
                } else {
                    throw new SQLException("ID not found");
                }
            }
            
        }
        
    }
    
    public void updateStudent(Student std) throws SQLException{
        String query = "UPDATE Students SET first_name = ?, last_name = ? ,dob = ? ,email = ?, phone = ?, department = ?, yearOfStudy = ? WHERE std_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, std.getFirst_name());
            prp.setString(2, std.getLast_name());
            prp.setString(3, std.getDob());
            prp.setString(4, std.getEmail());
            prp.setString(5, std.getPhone());
            prp.setString(6, std.getDepartment());
            prp.setInt(7, std.getYearOfStudy());
            prp.setInt(8, std.getStd_id());
            
            int rows_affected = prp.executeUpdate();
            if(rows_affected>0){
                System.out.println("Student updated.");
            } else {
                throw new SQLException("ID not found");
            }
            
            
        }
    }
    
    public void deleteStudent(int id) throws SQLException{
        String query = "DELETE FROM Students WHERE std_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            int rows_affected = prp.executeUpdate();
            if (rows_affected>0){
                System.out.println("Student deleted");
            } else {
                throw new SQLException("ID not found");
            }
        }
    }
    
    public void deleteAll() throws SQLException{
        String query = "DELETE FROM Students";
        try (Statement stmt = conn.createStatement()){
            stmt.executeUpdate(query);
            System.out.println("All students records were deleted.");
        }
    }
}
