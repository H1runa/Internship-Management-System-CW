package com.mycompany.internshipmanager.views;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class mig_test {

    public static void main(String[] args) {
        
        try{
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (UnsupportedLookAndFeelException ex){
            System.out.println("Look and feel not initialized.\n Error: "+ex.getMessage());
        }
        
        javax.swing.SwingUtilities.invokeLater(() -> {
        // Create a JFrame
           JFrame frame = new JFrame("MigLayout Example");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           // Set MigLayout as the layout manager
           frame.setLayout(new MigLayout(
               "wrap 2",  // Layout constraints: wrap after 2 columns
               "[25%][25%][25%][25%]", // Column constraints: both columns fill available space
               "[fill]"        // Row constraints: default
           ));

           // Add components with constraints
           frame.add(new JLabel("Username:"), "align right");
           frame.add(new JTextField(20), "span 2"); // Text field grows horizontally

           frame.add(new JLabel("Password:"), "align right");
           frame.add(new JPasswordField(20), "span 2");
           
           frame.add(new StudentItemPanel(1, "Hiruna"), "span");

           frame.add(new JButton("Login"), "align right, cell 3 3"); // Span across columns and center-align

           // Display the frame
           frame.pack();
           frame.setLocationRelativeTo(null);
           frame.setVisible(true);
    });
    }
}