package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.models.Application;
import com.mycompany.internshipmanager.models.Employer;
import com.mycompany.internshipmanager.models.Internship;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class ViewApplication extends javax.swing.JDialog {

    private EmployerController empControl = new EmployerController();
    private InternshipController internControl = new InternshipController();
    private ApplicationController applControl = new ApplicationController();
    private std_dashboard parent;
    
    private int applid;
    
    public ViewApplication(Application appl, std_dashboard parent) {
        super(parent, true);
        this.parent = parent;
        this.applid = appl.getApplication_id();
        
        initComponents();
        
        Internship intern = internControl.getInternshipByID(appl.getInternship_id());
        Employer employer = empControl.getEmployerByID(intern.getEmp_id());
        
        internNameLabel.setText(intern.getTitle());
        empNameLabel.setText(employer.getName());
        dateLabel.setText(appl.getDate());
        linkLabel.setText(appl.getResume());
        statusLabel.setText(appl.getStatus());
        
        empNamePanel.setBackground(Color.decode("#484848"));
        empNamePanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ViewEmployer(intern.getEmp_id(), ViewApplication.this).setVisible(true);
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                empNamePanel.setBackground(Color.decode("#585858"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                empNamePanel.setBackground(Color.decode("#484848"));
            }
            
            
            
        });
        
        setLocationRelativeTo(parent);
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                parent.gp.setVisible(false);
            }
            
        });
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        internNameLabel = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        linkLabel = new javax.swing.JLabel();
        empNamePanel = new javax.swing.JPanel();
        empNameLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        dateLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        deleteButton = new javax.swing.JButton();
        closeButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(690, 526));
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setText("Application");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, 200, 50));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Internship Name", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new java.awt.BorderLayout());

        internNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        internNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        internNameLabel.setText("Internship Name");
        jPanel2.add(internNameLabel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 550, 60));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Resume", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(new java.awt.BorderLayout());

        linkLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        linkLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        linkLabel.setText("Link");
        jPanel3.add(linkLabel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, 550, 60));

        empNamePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employer Name", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        empNamePanel.setLayout(new java.awt.BorderLayout());

        empNameLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        empNameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empNameLabel.setText("Employer Name");
        empNamePanel.add(empNameLabel, java.awt.BorderLayout.CENTER);

        jPanel1.add(empNamePanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 550, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Date Submitted", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setLayout(new java.awt.BorderLayout());

        dateLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        dateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        dateLabel.setText("Date");
        jPanel5.add(dateLabel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 550, 60));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel6.setLayout(new java.awt.BorderLayout());

        statusLabel.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Status");
        jPanel6.add(statusLabel, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 380, 550, 50));

        deleteButton.setBackground(new java.awt.Color(255, 102, 102));
        deleteButton.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        deleteButton.setText("Delete");
        deleteButton.setMaximumSize(new java.awt.Dimension(80, 30));
        deleteButton.setMinimumSize(new java.awt.Dimension(80, 30));
        deleteButton.setPreferredSize(new java.awt.Dimension(80, 30));
        deleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteButtonActionPerformed(evt);
            }
        });
        jPanel1.add(deleteButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, 110, 50));

        closeButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        closeButton1.setText("Close");
        closeButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        closeButton1.setMinimumSize(new java.awt.Dimension(80, 30));
        closeButton1.setPreferredSize(new java.awt.Dimension(80, 30));
        closeButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(closeButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 450, 110, 50));

        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButton1ActionPerformed
        ViewApplication.this.dispose();        
    }//GEN-LAST:event_closeButton1ActionPerformed

    private void deleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(ViewApplication.this, "Delete the selected application?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
        
        if (confirm == JOptionPane.YES_OPTION){        
            applControl.deleteApplication(applid);        
            parent.loadApplications();
            ViewApplication.this.dispose();        
        }        
    }//GEN-LAST:event_deleteButtonActionPerformed

    /**
     * @param args the command line arguments
     */
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton1;
    private javax.swing.JLabel dateLabel;
    private javax.swing.JButton deleteButton;
    private javax.swing.JLabel empNameLabel;
    private javax.swing.JPanel empNamePanel;
    private javax.swing.JLabel internNameLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JLabel linkLabel;
    private javax.swing.JLabel statusLabel;
    // End of variables declaration//GEN-END:variables
}
