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
                                       
//        ApplicationController c = new ApplicationController();
//        c.addApplication("1", "1", "2012-07-15", "whoa", "Accepted");
//        c.updateApplication(3, "1", "3", "2015-10-10", "i like women", "To be reviewed");
        
//        c.getApplications().forEach(a -> {view(a);});
        
        
    }
    
    public static void view(Application s){
        System.out.println("");
        System.out.println(s.getApplication_id());
        System.out.println(s.getDate());
        System.out.println(s.getStatus());
        System.out.println("");
    }
}
