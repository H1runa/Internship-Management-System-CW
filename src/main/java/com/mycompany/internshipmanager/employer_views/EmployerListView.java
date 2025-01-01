package com.mycompany.internshipmanager.employer_views;

import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.student_views.*;
import com.mycompany.internshipmanager.controllers.StudentController;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class EmployerListView extends javax.swing.JPanel {

    /**
     * Creates new form EmployerListView
     */
    EmployerController controller;
    EmployerItemContainer container;
    
    public EmployerListView() {
        initComponents();                        
        setLayout(new MigLayout("fill, flowy"));
//        setTitle("Student List");
        
        this.controller = new EmployerController();
        this.container = new EmployerItemContainer(controller.getEmployers());
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx"));      //centering the title requires a container   
        titlePanel.add(new JLabel("Student List"), "alignx center");
        add(titlePanel, "dock north");
        
        add(new JScrollPane(this.container), "span, grow"); //adding the student list to a scroll bar pane                
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
