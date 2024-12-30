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
        
        EmployerController controller = new EmployerController();
        controller.addEmployer("Joey", "wodwoodpeck@whatever.com", "0773737538");
//        controller.deleteEmployer(1);
//        controller.updateEmployer(1, "Peter", "legenday@gmail.com", "0112409191");
        viewEmployer(controller.getEmployerByID(12));
//        controller.getEmployers().forEach(a-> {viewEmployer(a);});
        
        
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
