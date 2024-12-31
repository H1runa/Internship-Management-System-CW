package com.mycompany.internshipmanager.controllers;

import java.util.List;
import com.mycompany.internshipmanager.models.Student;
import com.mycompany.internshipmanager.models.StudentDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


/**
 *
 * @author Asus
 */
public class StudentController {
    
    private StudentDAO dao;
    
    public StudentController(){      
       this.dao = new StudentDAO();
    }
    
    public void addStudent(String first_name, String last_name, String dob, String email, String phone, String department, int yearOfStudy){
        //name validation
        if (first_name == null || first_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            return;
        }
        if (last_name == null || last_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            return;
        }
        //dob validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Internship not added. \nInvalid input (DATE)");
            return;
        }
        
        //email validation
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            System.out.println("Internship not added.\nInvalid input (EMAIL)");
            return;
        }
        //phone number validation
        if (phone == null || phone.trim().isEmpty() || !phone.trim().matches("\\d{10}$")) {
            System.out.println("Internship not added.\nInvalid input (PHONE)");
            return;
        }
        
        
        Student std = new Student(0, first_name, last_name, dob ,email , phone, department, yearOfStudy);
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
    
    public void updateStudent(int id, String first_name, String last_name, String dob, String email, String phone, String department, int yearOfStudy){
        //name validation
        if (first_name == null || first_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            return;
        }
        if (last_name == null || last_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            return;
        }
        //dob validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Internship not added. \nInvalid input");
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
            Student std = new Student(id, first_name, last_name, dob ,email , phone, department, yearOfStudy);
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
