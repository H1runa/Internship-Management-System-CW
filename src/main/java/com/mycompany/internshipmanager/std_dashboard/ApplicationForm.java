package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.StudentController;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ApplicationForm extends javax.swing.JDialog {

    /**
     * Creates new form ApplicationForm
     */
    private ApplicationController applControl = new ApplicationController();    
    public JDialog parent;
    private int stdid, internid;
    private String today;
    
    public ApplicationForm(ViewInternship parent,int stdid, int internid) {                
        super(parent, true);
        this.parent = parent;
        this.stdid = stdid;
        this.internid = internid;
        LocalDate t = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.today = t.format(formatter);
        
        initComponents();
               
        
        setLocationRelativeTo(parent);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        linkField = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        submitButton = new javax.swing.JButton();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        title.setText("Link your resume");
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 280, 50));

        jLabel1.setText("*Enter a link to your resume. Note that it will be considered along with the other information gathered from your student profile");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 690, 50));
        panel.add(linkField, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 130, 450, 30));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        submitButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        submitButton.setText("Submit");
        submitButton.setMaximumSize(new java.awt.Dimension(80, 30));
        submitButton.setMinimumSize(new java.awt.Dimension(80, 30));
        submitButton.setPreferredSize(new java.awt.Dimension(80, 30));
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });
        jPanel1.add(submitButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 0, 100, 50));

        cancelButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        cancelButton.setText("Cancel");
        cancelButton.setMaximumSize(new java.awt.Dimension(80, 30));
        cancelButton.setMinimumSize(new java.awt.Dimension(80, 30));
        cancelButton.setPreferredSize(new java.awt.Dimension(80, 30));
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cancelButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 100, 50));

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 200, 450, 50));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
        
        if (linkField.getText().isEmpty()){
            JOptionPane.showMessageDialog(ApplicationForm.this, "Enter a valid link", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        try{        
            applControl.addApplication(String.valueOf(stdid), String.valueOf(internid), today , linkField.getText(), "To be reviewed");
            
            JOptionPane.showOptionDialog(
            ApplicationForm.this, 
            "Your application has been submitted.", 
            "Submission Successful", 
            JOptionPane.DEFAULT_OPTION, 
            JOptionPane.INFORMATION_MESSAGE, 
            null, 
            new Object[] {"OK"}, 
            "OK" 
        );
            ApplicationForm.this.dispose();
            parent.dispose();
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(ApplicationForm.this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex){
            JOptionPane.showMessageDialog(ApplicationForm.this, "Application not submitted", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_submitButtonActionPerformed

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        ApplicationForm.this.dispose();
    }//GEN-LAST:event_cancelButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField linkField;
    private javax.swing.JPanel panel;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
