package com.mycompany.internshipmanager.controllers;

import com.mycompany.internshipmanager.models.Application;
import com.mycompany.internshipmanager.models.ApplicationDAO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

public class ApplicationController {
    
    private ApplicationDAO dao;
    
    public ApplicationController(){
        this.dao = new ApplicationDAO();
    }
    
    public void addApplication(String stu_id, String internship_id, String date, String resume, String status){
        //name validation
        if (!status.equals("Accepted") && !status.equals("Rejected") && !status.equals("To be reviewed")){
            System.out.println("Application not added.\nInvalid input");
            return;
        }
        //date validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Application not added. \nInvalid input (DATE)");
            return;
        }
        
        int parsedStu_id = 0;
        int parsedInternship_id = 0;
        
        //parsing
        try{
            parsedStu_id = Integer.parseInt(stu_id);
            parsedInternship_id = Integer.parseInt(internship_id);
        } catch(NumberFormatException ex){
            System.out.println("Internship not added.\nError: "+ ex.getMessage());
            return;
        }

        
        Application appl = new Application(0, parsedStu_id, parsedInternship_id, date, resume, status);
        
        try {
            dao.addApplication(appl);
        } catch (SQLException ex) {
            System.out.println("Application could not be added. \n Error: "+ ex.getMessage());
//            ex.printStackTrace();
        }
    }
    
    public Application getApplicationByID(int id){
        try{
            return dao.getApplicationByID(id);
        } catch (SQLException ex){
            System.out.println("Application could not be retrieved. \nError: "+ ex.getMessage());
            return null;
        }                 
    }
    
    public List<Application> getApplications(){
        try{
            return dao.getApplications();
        } catch (SQLException ex){
            System.out.println("Application list could not be retrieved. \n Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public void updateApplication(int id, String stu_id, String internship_id, String date, String resume, String status){
         //name validation
        if (!status.equals("Accepted") && !status.equals("Rejected") && !status.equals("To be reviewed")){
            System.out.println("Application not added.\nInvalid input");
            return;
        }
        //date validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(date, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Application not added. \nInvalid input (DATE)");
            return;
        }
        
        int parsedStu_id = 0;
        int parsedInternship_id = 0;
        
        //parsing
        try{
            parsedStu_id = Integer.parseInt(stu_id);
            parsedInternship_id = Integer.parseInt(internship_id);
        } catch(NumberFormatException ex){
            System.out.println("Internship not added.\nError: "+ ex.getMessage());
            return;
        }

        
        Application appl = new Application(id, parsedStu_id, parsedInternship_id, date, resume, status);
        try{
            dao.updateApplication(appl);            
            
        } catch (SQLException ex){
            System.out.println("Application could not be updated. \nError: " + ex.getMessage());
        }
        
    }
    
    public void deleteApplication(int id) {
        try{
            dao.deleteApplication(id);
            
        } catch (SQLException ex){
            System.out.println("Application could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
    public void deleteAll(){
        try{
            dao.deleteAll();
            
        } catch (SQLException ex){
            System.out.println("Application list could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
}
