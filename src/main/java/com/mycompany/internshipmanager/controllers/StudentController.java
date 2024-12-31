package com.mycompany.internshipmanager.controllers;

import java.util.List;
import com.mycompany.internshipmanager.models.Student;
import com.mycompany.internshipmanager.models.StudentDAO;
import java.sql.SQLException;


/**
 *
 * @author Asus
 */
public class StudentController {
    
    private StudentDAO dao;
    
    public StudentController(){      
       this.dao = new StudentDAO();
    }
    
    public void addStudent(String name, String em, String ph){
        //name validation
        if (name == null || name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            return;
        }
        //email validation
        if (em == null || !em.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //phone number validation
        if (ph == null || ph.trim().isEmpty() || !ph.trim().matches("\\d{10}$")) {
            System.out.println("Internship not added.\nInvalid input");
            return;
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
    
    public void updateStudent(int id, String name, String email, String phone){
        //name validation
        if (name == null || name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //email validation
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //phone number validation
        if (phone == null || phone.trim().isEmpty() || !phone.trim().matches("\\d{10}$")) {
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        try{
            Student std = new Student(id, name, email, phone);
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
