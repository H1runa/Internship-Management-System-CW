package com.mycompany.internshipmanager.controllers;

import com.mycompany.internshipmanager.models.EmployerDAO;
import com.mycompany.internshipmanager.models.Employer;
import java.sql.SQLException;
import java.util.List;

public class EmployerController {
    
    private EmployerDAO dao;
    
    public EmployerController(){
        this.dao = new EmployerDAO();
    }
    
    public void addEmployer(String name, String email, String phone, String description, String industry){
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
        //desc validation
        if (description == null || description.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //industry validation
        if (industry == null || industry.trim().isEmpty()){ //only adding basic validation for now. may do something more with this later
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        
        Employer emp = new Employer(0, name, email, phone, description, industry);
        
        try {
            dao.addEmployer(emp);
        } catch (SQLException ex) {
            System.out.println("Employer could not be added. \n Error: "+ ex.getMessage());
        }
    }
    
    public Employer getEmployerByID(int id){
        try{
            return dao.getEmployerByID(id);
        } catch (SQLException ex){
            System.out.println("Employer could not be retrieved. \nError: "+ ex.getMessage());
            return null;
        }                 
    }
    
    public List<Employer> getEmployers(){
        try{
            return dao.getEmployers();
        } catch (SQLException ex){
            System.out.println("Employer list could not be retrieved. \n Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public void updateEmployer(int id, String name, String email, String phone, String description, String industry){
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
        //desc validation
        if (description == null || description.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //industry validation
        if (industry == null || industry.trim().isEmpty()){ //only adding basic validation for now. may do something more with this later
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        
        Employer emp = new Employer(id, name, email, phone, description, industry);
        try{
            dao.updateEmployer(emp);            
            
        } catch (SQLException ex){
            System.out.println("Employer could not be updated. \nError: " + ex.getMessage());
        }
        
    }
    
    public void deleteEmployer(int id) {
        try{
            dao.deleteEmployer(id);
            
        } catch (SQLException ex){
            System.out.println("Employer could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
    public void deleteAll(){
        try{
            dao.deleteAll();
            
        } catch (SQLException ex){
            System.out.println("Employer list could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
}
