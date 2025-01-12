package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.EmployerLoginDAO;
import com.mycompany.internshipmanager.models.StudentLoginDAO;
import java.sql.SQLException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class RegisterEmployer extends javax.swing.JDialog {

    /**
     * Creates new form RegisterStudent
     */
    private EmployerLoginDAO dao;
    private EmployerController empControl;
    
    public RegisterEmployer(JDialog parent) {      
        super(parent, true);
        initComponents();
        
        this.dao = new EmployerLoginDAO();
        this.empControl = new EmployerController();
        
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
        jPanel1 = new javax.swing.JPanel();
        phone = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        industry = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        name = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        email = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        password1 = new javax.swing.JTextField();
        password2 = new javax.swing.JTextField();
        registerButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(560, 658));
        setMinimumSize(new java.awt.Dimension(560, 658));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(560, 658));
        setResizable(false);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Register");
        panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 10, 150, 50));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Phone Number", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new java.awt.BorderLayout());

        phone.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        phone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phoneActionPerformed(evt);
            }
        });
        jPanel1.add(phone, java.awt.BorderLayout.CENTER);

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, 480, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Industry", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new java.awt.BorderLayout());

        industry.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel2.add(industry, java.awt.BorderLayout.CENTER);

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 480, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Company Name", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(new java.awt.BorderLayout());

        name.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel3.add(name, java.awt.BorderLayout.CENTER);

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 480, 50));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new java.awt.BorderLayout());

        description.setColumns(20);
        description.setLineWrap(true);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        jPanel4.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 210, 480, 100));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Email", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setLayout(new java.awt.BorderLayout());

        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel5.add(email, java.awt.BorderLayout.CENTER);

        panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 380, 480, -1));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Password (Enter Twice)", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel6.setLayout(new java.awt.BorderLayout());

        password1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        password1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                password1ActionPerformed(evt);
            }
        });
        jPanel6.add(password1, java.awt.BorderLayout.CENTER);

        password2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel6.add(password2, java.awt.BorderLayout.PAGE_END);

        panel.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 440, 480, 80));

        registerButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        registerButton.setText("Register");
        registerButton.setMaximumSize(new java.awt.Dimension(80, 30));
        registerButton.setMinimumSize(new java.awt.Dimension(80, 30));
        registerButton.setPreferredSize(new java.awt.Dimension(80, 30));
        registerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registerButtonActionPerformed(evt);
            }
        });
        panel.add(registerButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 550, 120, 50));

        closeButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closeButton.setText("Close");
        closeButton.setMaximumSize(new java.awt.Dimension(80, 30));
        closeButton.setMinimumSize(new java.awt.Dimension(80, 30));
        closeButton.setPreferredSize(new java.awt.Dimension(80, 30));
        closeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButtonActionPerformed(evt);
            }
        });
        panel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 550, 120, 50));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void phoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_phoneActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailActionPerformed

    private void password1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_password1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_password1ActionPerformed

    private void registerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registerButtonActionPerformed
        if (!email.getText().isEmpty() && !password1.getText().isEmpty()){
            if (password1.getText().equals(password2.getText())){
                try{
                    this.dao.addEmployer(email.getText(), password1.getText());
                    empControl.addEmployer(name.getText(), email.getText(), phone.getText(), description.getText(), industry.getText());
                    RegisterEmployer.this.dispose();
                } catch (SQLException ex){
                    JOptionPane.showMessageDialog(RegisterEmployer.this, "Employer not registered", "Database Error" ,JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex){
                    JOptionPane.showMessageDialog(RegisterEmployer.this, ex.getMessage(), "Input Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(RegisterEmployer.this, "Password did not match", "Password Error" ,JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(RegisterEmployer.this, "Empty Fields", "Null Values" ,JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_registerButtonActionPerformed

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        RegisterEmployer.this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JTextArea description;
    private javax.swing.JTextField email;
    private javax.swing.JTextField industry;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField name;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField password1;
    private javax.swing.JTextField password2;
    private javax.swing.JTextField phone;
    private javax.swing.JButton registerButton;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
