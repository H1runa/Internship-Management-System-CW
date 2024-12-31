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
        
       
        
        
    }
    
    public static void viewEmployer(Employer emp){
        System.out.println("");
        System.out.println(emp.getEmp_id());
        System.out.println(emp.getName());
        System.out.println(emp.getEmail());
        System.out.println(emp.getPhone());
        System.out.println(""); //line break for mulitple students
    }
}
