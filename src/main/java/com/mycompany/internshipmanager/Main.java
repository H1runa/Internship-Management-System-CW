package com.mycompany.internshipmanager;

import com.mycompany.internshipmanager.models.*;
import com.mycompany.internshipmanager.controllers.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        
        //making sure the database conn is closed when exiting the application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> 
        {
            DBConnection.closeConnection();
                }
            )
        );
        InternshipController c = new InternshipController();
        
        
//        viewInternship(c.getInternshipByID(1));
//        c.addInternship("Instructor", "You can be useless for 2 months", "2", "2", "Open");
//          c.deleteInternship(15);
//            c.updateInternship(2, "Professional Skating", "You skate to your hearts content", "3", "15", "Open");
        
       
        
        
    }
    
    public static void viewInternship(Internship i){
        System.out.println("");
        System.out.println(i.getId());
        System.out.println(i.getTitle());
        System.out.println(i.getDescription());
        System.out.println(i.getEmp_id());
        System.out.println(i.getDuration());
        System.out.println(i.getStatus());
        System.out.println(""); //line break for mulitple students
    }
}
