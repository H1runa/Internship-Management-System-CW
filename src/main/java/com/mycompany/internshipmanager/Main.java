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
    
    public static void view(Employer s){
        System.out.println("");
        System.out.println(s.getEmp_id());
        System.out.println(s.getName());
        System.out.println(s.getDescription());
        System.out.println("");
    }
}
