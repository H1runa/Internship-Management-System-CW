package com.mycompany.internshipmanager.controllers;

import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.InternshipDAO;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

public class InternshipController {
    private InternshipDAO dao;
    
    public InternshipController(){
        this.dao = new InternshipDAO();
    }
    
    public void addInternship(String title, String desc, String emp_id, String duration, String status){
        //title validation
        if (title == null || title.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Title");
        }
        //description validation
        if (desc == null || desc.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Description");
        }
        // status validation
        if (!status.equals("Open") && !status.equals("Closed")){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Status");
        }
        //basic emp_id validation for integer
        if (!emp_id.matches("\\d+")){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Employer ID");
        }
        //duration validation
        if (!duration.matches("\\d+")){
            System.out.println("Internship not added.\nInvalid input");
            throw new IllegalArgumentException("Invalid Duration");
        }
        
        int parsedEmp_id = 0; //vars to hold the parsed value
        int parsedDuration = 0;
        
        //parsing
        try{
            parsedEmp_id = Integer.parseInt(emp_id);
            parsedDuration = Integer.parseInt(duration);
        } catch(NumberFormatException ex){
            System.out.println("Internship not added.\nError: "+ ex.getMessage());
            throw new IllegalArgumentException("Invalid Employer ID or Duration entered");
        }

        Internship intern = new Internship(0, title, desc, parsedEmp_id, parsedDuration, status);
        
        try {
            dao.addInternship(intern);
        } catch (SQLException ex) {
            System.out.println("Internship could not be added. \n Error: "+ ex.getMessage());            
        }
    }
    
    public Internship getInternshipByID(int id){
        try{
            return dao.getInternshipByID(id);
        } catch (SQLException ex){
            System.out.println("Internship could not be retrieved. \nError: "+ ex.getMessage());
            return null;
        }                 
    }
    
    public List<Internship> getInternships(){
        try{
            return dao.getInternships();
        } catch (SQLException ex){
            System.out.println("Internship list could not be retrieved. \n Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public void updateInternship(int id, String title, String desc, String emp_id, String duration, String status){
         //title validation
        if (title == null || title.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //description validation
        if (desc == null || desc.trim().isEmpty()){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        // status validation
        if (!status.equals("Open") && !status.equals("Closed")){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //basic emp_id validation for integer
        if (!emp_id.matches("\\d+")){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        //duration validation
        if (!duration.matches("\\d+")){
            System.out.println("Internship not added.\nInvalid input");
            return;
        }
        
        int parsedEmp_id = 0; //vars to hold the parsed value
        int parsedDuration = 0;
        
        //parsing
        try{
            parsedEmp_id = Integer.parseInt(emp_id);
            parsedDuration = Integer.parseInt(duration);
        } catch(NumberFormatException ex){
            System.out.println("Internship not added.\nError: "+ ex.getMessage());
            return;
        }

        Internship intern = new Internship(id, title, desc, parsedEmp_id, parsedDuration, status);
        try{
            dao.updateInternship(intern);            
            
        } catch (SQLException ex){
            System.out.println("Internship could not be updated. \nError: " + ex.getMessage());
        }
        
    }
    
    public void deleteInternship(int id) throws SQLException {
        
        dao.deleteInternship(id);
            
        
    }
    
    public void deleteAll(){
        try{
            dao.deleteAll();
            
        } catch (SQLException ex){
            System.out.println("Internship list could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
}
