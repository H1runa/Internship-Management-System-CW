package com.mycompany.internshipmanager.employer_views;

import com.mycompany.internshipmanager.models.Employer;
import com.mycompany.internshipmanager.student_views.*;
import com.mycompany.internshipmanager.models.Student;
import java.awt.Color;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class EmployerItemContainer extends javax.swing.JPanel {

    /**
     * Creates new form StudentItemContainer
     */
    public EmployerItemContainer(List<Employer> emps) {               
        //layout
        setLayout(new MigLayout("wrap 1", "[fill, grow]", "[]"));
        setBackground(Color.LIGHT_GRAY);
        
        for (Employer emp : emps){
            add(new EmployerItemPanel(emp.getEmp_id(), emp.getName()), "align center");
        }

//        add(new EmployerItemPanel(1, "Kite man"));
        
        
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
