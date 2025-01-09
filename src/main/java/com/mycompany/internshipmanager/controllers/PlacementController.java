package com.mycompany.internshipmanager.controllers;

import com.mycompany.internshipmanager.models.Placement;
import com.mycompany.internshipmanager.models.PlacementDAO;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;


public class PlacementController {
    private PlacementDAO dao;
    
    public PlacementController(){
        this.dao = new PlacementDAO();
    }
    
    public void addPlacement(String std_id, String internship_id, String emp_id, String status, String start_date, String end_date, String feedback){
        //status validation
        if (!status.equals("Ongoing") && !status.equals("Finished") && !status.equals("Cancelled")){
            System.out.println("Placement not added.\nInvalid input");
            return;
        }
        //date validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(start_date, formatter);
            LocalDate.parse(end_date, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Placement not added. \nInvalid input (DATE)");
            return;
        }
        
        int parsedStd_id = 0;
        int parsedInternship_id = 0;
        int parsedEmp_id = 0;
        
        //parsing
        try{
            parsedStd_id = Integer.parseInt(std_id);
            parsedInternship_id = Integer.parseInt(internship_id);
            parsedEmp_id = Integer.parseInt(emp_id);
        } catch(NumberFormatException ex){
            System.out.println("Placement not added.\nError: "+ ex.getMessage());
            return;
        }

        
        Placement pla = new Placement(0, parsedStd_id, parsedInternship_id, parsedEmp_id , status, start_date, end_date, feedback);
        
        try {
            dao.addPlacement(pla);
        } catch (SQLException ex) {
            System.out.println("Placement could not be added. \n Error: "+ ex.getMessage());
//            ex.printStackTrace();
        }
    }
    
    public Placement getPlacementByID(int id){
        try{
            return dao.getPlacementByID(id);
        } catch (SQLException ex){
            System.out.println("Placement could not be retrieved. \nError: "+ ex.getMessage());
            return null;
        }                 
    }
    
    public List<Placement> getPlacements(){
        try{
            return dao.getPlacements();
        } catch (SQLException ex){
            System.out.println("Placement list could not be retrieved. \n Error: "+ ex.getMessage());
        }
        
        return null;
    }
    
    public void updatePlacement(int id, String std_id, String internship_id, String emp_id, String status, String start_date, String end_date, String feedback){
         //status validation
        if (!status.equals("Ongoing") && !status.equals("Finished") && !status.equals("Cancelled")){
            System.out.println("Placement not added.\nInvalid input");
            return;
        }
        //date validation
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        try{
            LocalDate.parse(start_date, formatter);
            LocalDate.parse(end_date, formatter);
        } catch (DateTimeParseException ex){
            System.out.println("Placement not added. \nInvalid input (DATE)");
            return;
        }
        
        int parsedStd_id = 0;
        int parsedInternship_id = 0;
        int parsedEmp_id = 0;
        
        //parsing
        try{
            parsedStd_id = Integer.parseInt(std_id);
            parsedInternship_id = Integer.parseInt(internship_id);
            parsedEmp_id = Integer.parseInt(emp_id);
        } catch(NumberFormatException ex){
            System.out.println("Placement not added.\nError: "+ ex.getMessage());
            return;
        }

        
        Placement pla = new Placement(id, parsedStd_id, parsedInternship_id, parsedEmp_id , status, start_date, end_date, feedback);
        
        try{
            dao.updatePlacement(pla);            
            
        } catch (SQLException ex){
            System.out.println("Placement could not be updated. \nError: " + ex.getMessage());
        }
        
    }
    
    public void deletePlacement(int id) {
        try{
            dao.deletePlacement(id);
            
        } catch (SQLException ex){
            System.out.println("Placement could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
    public void deleteAll(){
        try{
            dao.deleteAll();
            
        } catch (SQLException ex){
            System.out.println("Placement list could not be deleted. \nError: "+ ex.getMessage());
        }
    }
    
    public int getInternshipsFinished(int id){
        try{
            return dao.getInternshipsFinished(id);
        } catch (SQLException ex){
            System.out.println("Couldn't retrieve finished internships");
        }
        
        return 0;
    }
    
    public int getInternshipsOngoing(int id){
        try{
            return dao.getInternshipsOngoing(id);
        } catch (SQLException ex){
            System.out.println("Couldn't retrieve ongoing internships");
        }
        
        return 0;
    }
    
    public int getInternshipsCancelled(int id){
        try{
            return dao.getInternshipsCancelled(id);
        } catch (SQLException ex){
            System.out.println("Couldn't retrieve cancelled internships");
        }
        
        return 0;
    }
    
}
