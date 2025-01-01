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
    
    public void addStudent(String first_name, String last_name, String dob, String email, String phone, String department, String yearOfStudy){
        //name validation
        if (first_name == null || first_name.trim().isEmpty()){
            System.out.println("Student not added.\nInvalid input"); //add proper error handling here later
            throw new IllegalArgumentException("Invalid First Name");
        }
        if (last_name == null || last_name.trim().isEmpty()){
            System.out.println("Student not added.\nInvalid input"); //add proper error handling here later
            throw new IllegalArgumentException("Invalid Last Name");
        }
        //dob validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Student not added. \nInvalid input (DATE)");
            throw new IllegalArgumentException("Invalid Date");
        }
        
        //email validation
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            System.out.println("Student not added.\nInvalid input (EMAIL)");
            throw new IllegalArgumentException("Invalid Email");
        }
        //phone number validation
        if (phone == null || phone.trim().isEmpty() || !phone.trim().matches("\\d{10}$")) {
            System.out.println("Student not added.\nInvalid input (PHONE)");
            throw new IllegalArgumentException("Invalid Contact Number");
        }
        //yos validation
        int yos = 0;
        try{
            yos = Integer.parseInt(yearOfStudy);
        } catch (NumberFormatException ex){
            System.out.println("Student not added.\nInvalid input (YOS)");
            throw new IllegalArgumentException("Invalid number of years");
        }
        
        
        Student std = new Student(0, first_name, last_name, dob ,email , phone, department, yos);
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
    
    public void updateStudent(int id, String first_name, String last_name, String dob, String email, String phone, String department, String yearOfStudy){
        //name validation
        if (first_name == null || first_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            throw new IllegalArgumentException("Invalid First Name");
        }
        if (last_name == null || last_name.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input"); //add proper error handling here later
            throw new IllegalArgumentException("Invalid Last Name");
        }
        //dob validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(dob, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Internship not added. \nInvalid input");
            throw new IllegalArgumentException("Invalid Date of Birth");
        }
        
        //email validation
        if (email == null || !email.trim().matches("^[A-Za-z0-9+_.-]+@(.+)$")){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Email");
        }
        //phone number validation
        if (phone == null || phone.trim().isEmpty() || !phone.trim().matches("\\d{10}$")) {
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Contact Number");
        }
        
        //yos validation
        int yos = 0;
        try{
            yos = Integer.parseInt(yearOfStudy);
        } catch (NumberFormatException ex){
            System.out.println("Student not added.\nInvalid input (YOS)");
            throw new IllegalArgumentException("Invalid number of years");
        }
        
        try{
            Student std = new Student(id, first_name, last_name, dob ,email , phone, department, yos);
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
