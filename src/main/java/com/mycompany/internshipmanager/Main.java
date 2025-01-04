package com.mycompany.internshipmanager;

import com.mycompany.internshipmanager.student_view.MainGUI;
import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

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
        
        //adding custom look and feel
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex){
            System.out.println("Look and feel not initialized: " + ex.getMessage());
        }
        
        new MainGUI().setVisible(true);
    }
}
    

                                       
        

    
    
    

