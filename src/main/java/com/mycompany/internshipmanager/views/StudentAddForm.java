package com.mycompany.internshipmanager.views;

import com.mycompany.internshipmanager.NavHistory;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.custom_ui.BackButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;


public class StudentAddForm extends javax.swing.JPanel {

    private StudentAddForm referencecopy;
    private StudentController control;
    
    
    public StudentAddForm() {
        initComponents();
        
        this.referencecopy = this;
        this.control = new StudentController();
        
        setLayout(new MigLayout("fill, flowy"));
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        JPanel contentPanel = new JPanel(new MigLayout("wrap 2, fillx", "[]15[]", "[]15[]"));
        JPanel buttonPanel = new JPanel(new MigLayout());
        
        BackButton back = new BackButton("<-", this);       
        
        titlePanel.add(back, "cell 0 0, align left");        
        titlePanel.add(new JLabel("Register"), "cell 1 0, align center"); //title                        
        
        add(titlePanel, "dock north");
        
        contentPanel.add(new JLabel("First Name: "), "align label");
        JTextField fname = new JTextField();
        contentPanel.add(fname, "growx, wrap");
        
        contentPanel.add(new JLabel("Second Name: "), "align label");
        JTextField lname = new JTextField();
        contentPanel.add(lname, "growx, wrap");
        
        contentPanel.add(new JLabel("Date (yyyy-MM-dd): "), "align label");
        JTextField date = new JTextField();
        contentPanel.add(date, "growx, wrap");
        
        contentPanel.add(new JLabel("Email: "), "align label");
        JTextField email = new JTextField();
        contentPanel.add(email, "growx, wrap");
        
        contentPanel.add(new JLabel("Contact Number: "), "align label");
        JTextField phone = new JTextField();
        contentPanel.add(phone, "growx, wrap");
        
        contentPanel.add(new JLabel("Department: "), "align label");
        JTextField dep = new JTextField();
        contentPanel.add(dep, "growx, wrap");
        
        contentPanel.add(new JLabel("Year of Study: "), "align label");
        JTextField yos = new JTextField();
        contentPanel.add(yos, "growx, wrap");  
        
        add(contentPanel, "dock center");
      
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
