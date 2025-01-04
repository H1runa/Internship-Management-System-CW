package com.mycompany.internshipmanager.views.internship;

import com.formdev.flatlaf.FlatClientProperties;
import com.mycompany.internshipmanager.LoggedEmployer;
import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.custom_ui.BackButton;
import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class InternshipAddForm extends javax.swing.JPanel {

    InternshipController control;
    
    
    public InternshipAddForm() {
        initComponents();
        this.control = new InternshipController();
        
        setLayout(new MigLayout("fill")); //layout
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        JPanel contentPanel = new JPanel(new MigLayout("fillx, wrap 1", "[]", "[]15[]"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[]15[]"));
        
        JLabel title = new JLabel("Create Internship");
        BackButton back = new BackButton("<-)", this);
        
        titlePanel.add(back, "cell 0 0, align left");
        titlePanel.add(title, "cell 1 0, align center");
        
        JPanel tPanel = new JPanel(new BorderLayout());         //defining the fields to enter data
        tPanel.setBorder(BorderFactory.createTitledBorder("Enter Title"));        
        JTextField tField = new JTextField();
        tPanel.add(tField, BorderLayout.CENTER);
        contentPanel.add(tPanel, "growx, shrinkx");
        
        JPanel descPanel = new JPanel(new BorderLayout());
        descPanel.setBorder(BorderFactory.createTitledBorder("Enter Description"));
        JTextArea desc = new JTextArea(4, 10);
        desc.setLineWrap(true); desc.setWrapStyleWord(true);
        descPanel.add(desc, BorderLayout.CENTER);
        contentPanel.add(descPanel, "growx, shrinkx");
        
        JPanel dPanel = new JPanel(new BorderLayout());
        dPanel.setBorder(BorderFactory.createTitledBorder("Enter Duration in months"));        
        JTextField duration = new JTextField();
        dPanel.add(duration, BorderLayout.CENTER);
        contentPanel.add(dPanel, "growx, shrinkx");
        
        JPanel statusPanel = new JPanel(new BorderLayout());
        statusPanel.setBorder(BorderFactory.createTitledBorder("Select Status"));
        JComboBox status = new JComboBox(new String[] {"Open", "Closed"});
        statusPanel.add(status, BorderLayout.CENTER);
        contentPanel.add(statusPanel);
        
        JButton submit = new JButton("Submit"); //defining the buttons
        submit.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getButton() == 1){
                    try{
                        control.addInternship(tField.getText(), desc.getText(), String.valueOf(LoggedEmployer.getInstance().getEmployer().getEmp_id()) , duration.getText() , status.getSelectedItem().toString());
                    } catch (IllegalArgumentException ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });
        
        buttonPanel.add(submit, "cell 0 0, align right");
        
        JButton close = new JButton("Close");
        close.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                if (e.getButton() == 1){
                    System.exit(0);
                }
            }
            
        });
        
        buttonPanel.add(close, "cell 1 0, align left");
        
        
        add(titlePanel, "dock north, growx, shrinkx"); //adding title panel to the main frame
        add(contentPanel, "dock center"); //adding content panel to the main frame
        add(buttonPanel, "dock south"); //adding the button paenl to the main frame
                
        
    }

    
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
