package com.mycompany.internshipmanager.controllers;

import com.mycompany.internshipmanager.DBConnection;
import java.util.List;
import com.mycompany.internshipmanager.models.Student;
import com.mycompany.internshipmanager.models.StudentDAO;
import java.sql.SQLException;
import java.sql.Connection;

/**
 *
 * @author Asus
 */
public class StudentController {
    
    private StudentDAO dao;
    private Connection conn;
    
    public StudentController(){
       this.conn = DBConnection.getConnection();
       this.dao = new StudentDAO();
    }
    
    public void addStudent(String name, String em, String ph){
        //name validation
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        //email validation
        if (em == null || !em.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Invalid email");
        }
        //phone number validation
        if (ph == null || ph.trim().isEmpty() || !ph.trim().matches("\\d{10}$")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        
        Student std = new Student(0, name, em , ph);
        try{
            dao.addStudent(std);
        }catch (SQLException ex){
            System.out.println("Student data could not be added.\n Error: "+ex.getMessage());
        }
        
    }
    
    public List<Student> getStudents(){
        try{
            return dao.getStudents();
        }catch (SQLException ex){
            System.out.println("Students data could not be retrieved. \nError: "+ ex.getMessage());
            return null;
        }
    }
    
    public Student getStudentByID(int id){        
        try{
            return dao.getStudentByID(id);
        } catch(SQLException ex){
            System.out.println("Student data could not be retrieved. \n Error: "+ex.getMessage());
            return null;
        }
    }
    
    public void updateStudent(String name, String email, String phone){
        //name validation
        if (name == null || name.trim().isEmpty()){
            throw new IllegalArgumentException("Invalid name");
        }
        //email validation
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            throw new IllegalArgumentException("Invalid email");
        }
        //phone number validation
        if (phone == null || phone.trim().isEmpty() || !phone.trim().matches("\\d{10}$")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        try{
            Student std = new Student(0, name, email, phone);
            dao.updateStudent(std);
        } catch (SQLException ex){
            System.out.println("Student details could not be updated. \n Error: "+ ex. getMessage());
        }
    }
    
    public void deleteStudent(int id){
        
        try{
            dao.deleteStudent(id);            
        } catch(SQLException ex){
            System.out.println("Student could not be deleted. \n Error: "+ ex.getMessage());
        }
    }
    
    public void deleteAll(){
        try{
            dao.deleteAll();
        } catch (SQLException ex){
            System.out.println("Students could not be deleted. \n Error: " + ex.getMessage());
        }
    }
    
    
    
    
}