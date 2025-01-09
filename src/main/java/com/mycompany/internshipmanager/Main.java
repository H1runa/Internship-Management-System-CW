package com.mycompany.internshipmanager;

import com.formdev.flatlaf.FlatDarkLaf;
import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.emp_dashboard.emp_dashboard;
import com.mycompany.internshipmanager.std_dashboard.Login;
import com.mycompany.internshipmanager.std_dashboard.RegisterEmployer;
import com.mycompany.internshipmanager.std_dashboard.RegisterStudent;
import com.mycompany.internshipmanager.std_dashboard.std_dashboard;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        
//        StudentController c = new StudentController();
//        LoggedStudent.getInstance().setStudent(c.getStudentByID(1));
        
         //making sure the database conn is closed when exiting the application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> 
        {
            DBConnection.closeConnection();
                }
            )
        );
        
        //adding custom look and feel
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex){
            System.out.println("Look and feel not initialized: " + ex.getMessage());
        }
        
//        new std_dashboard(1).setVisible(true);
//        new RegisterStudent().setVisible(true);
        new Login().setVisible(true);
//          new RegisterEmployer().setVisible(true);
    }
}
    

                                       
        

    
    
    

