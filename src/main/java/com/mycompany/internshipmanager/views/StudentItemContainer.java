package com.mycompany.internshipmanager.views;

import com.mycompany.internshipmanager.models.Student;
import java.awt.Color;
import java.util.List;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class StudentItemContainer extends javax.swing.JPanel {

    /**
     * Creates new form StudentItemContainer
     */
    public StudentItemContainer(List<Student> stds) {               
        //layout
        setLayout(new MigLayout("wrap 1", "[fill, grow]", "[]"));
        setBackground(Color.LIGHT_GRAY);
        
        for (Student std : stds){
            add(new StudentItemPanel(std.getStd_id(), std.getFirst_name()+" "+std.getLast_name()), "align center");
        }

//        add(new StudentItemPanel(1, "Kite man"));
        
        
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
