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
        String query = "INSERT INTO Students (name, email, phone) VALUES (? , ? , ?)";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, std.getName());
            prp.setString(2, std.getEmail());
            prp.setString(3, std.getPhone());
            prp.executeUpdate();
            
            System.out.println("Added student.");
        } //no need for catch cuz we got try with resources
    }
    
    public List<Student> getStudents() throws SQLException{
        String query = "SELECT * FROM Students";
        List<Student> stdList = new ArrayList<Student>();
        try(Statement st = conn.createStatement(); ResultSet rs = st.executeQuery(query)){
            while(rs.next()){
                Student std = new Student(rs.getInt("std_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
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
                    Student std = new Student(rs.getInt("std_id"), rs.getString("name"), rs.getString("email"), rs.getString("phone"));
                    return std;
                }
            }
            System.out.println("Student details retrieved.");
        }
        
        return null;
    }
    
    public void updateStudent(Student std) throws SQLException{
        String query = "UPDATE Students SET name = ?, email = ?, phone = ? WHERE std_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setString(1, std.getName());
            prp.setString(2, std.getEmail());
            prp.setString(3, std.getPhone());
            prp.setInt(4, std.getStd_id());
            
            prp.executeUpdate();
            
            System.out.println("Student updated.");
        }
    }
    
    public void deleteStudent(int id) throws SQLException{
        String query = "DELETE FROM Students WHERE std_id = ?";
        try(PreparedStatement prp = conn.prepareStatement(query)){
            prp.setInt(1, id);
            prp.executeUpdate();
            
            System.out.println("Student deleted");
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
