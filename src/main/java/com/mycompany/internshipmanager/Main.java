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
        
//        PlacementController c = new PlacementController();
//        c.addPlacement("1", "1", "1", "Ongoing", "2014-05-06", "2015-10-12", "Good but kinda bad too");
//        c.updatePlacement(1, "1", "1","1", "Finished", "2014-05-06", "2011-12-11", "work is all he knows");
//        c.deletePlacement(1);
//        c.deleteAll();
        
//        c.getPlacements().forEach(a -> {view(a);});
                                       
        
        
    }
    
    public static void view(Placement s){
        System.out.println("");
        System.out.println(s.getStart_date());
        System.out.println(s.getEnd_date());
        System.out.println(s.getStatus());
        System.out.println(s.getFeedback());
        System.out.println("");
    }
}
