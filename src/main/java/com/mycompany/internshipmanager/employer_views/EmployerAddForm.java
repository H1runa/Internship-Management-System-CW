package com.mycompany.internshipmanager.employer_views;

import com.mycompany.internshipmanager.student_views.*;
import com.mycompany.internshipmanager.NavHistory;
import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.custom_ui.BackButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Stack;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import net.miginfocom.swing.MigLayout;


public class EmployerAddForm extends javax.swing.JPanel {
    
    private EmployerController control;
    
    
    public EmployerAddForm() {
        initComponents();
                
        this.control = new EmployerController();
                
        setLayout(new MigLayout("fill, flowy"));
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        JPanel contentPanel = new JPanel(new MigLayout("wrap 2, fillx", "[]15[]", "[]15[]"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[]20[]"));
        
        BackButton back = new BackButton("<-", this);       
        
        titlePanel.add(back, "cell 0 0, align left");        
        titlePanel.add(new JLabel("Register Employer"), "cell 1 0, align center"); //title                        
        
        add(titlePanel, "dock north");
        
        contentPanel.add(new JLabel("Company Name: "), "align label"); //form
        JTextField cname = new JTextField();
        contentPanel.add(cname, "growx, wrap");
        
        contentPanel.add(new JLabel("Email: "), "align label");
        JTextField email = new JTextField();
        contentPanel.add(email, "growx, wrap");
        
        contentPanel.add(new JLabel("Contact Number: "), "align label");
        JTextField phone = new JTextField();
        contentPanel.add(phone, "growx, wrap");
        
        contentPanel.add(new JLabel("Company Description: "), "align label");
        JTextField desc = new JTextField();
        contentPanel.add(desc, "growx, wrap");
        
        contentPanel.add(new JLabel("Industry: "), "align label");
        JTextField industry = new JTextField();
        contentPanel.add(industry, "growx, wrap");
        
        add(contentPanel, "dock center");
        
        JButton register = new JButton("Register"); //buttons
        register.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                try{
                    control.addEmployer(cname.getText(), email.getText(), phone.getText(), desc.getText(), industry.getText());
                } catch(IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        buttonPanel.add(register, "align right");
        
        JButton close = new JButton("Close");
        close.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                System.exit(0);
            }
        });
        buttonPanel.add(close, "align left");
        
        add(buttonPanel, "dock south"); //button panel
      
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