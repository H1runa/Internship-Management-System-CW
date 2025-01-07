package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.models.Employer;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDialog;
import javax.swing.text.DefaultCaret;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Asus
 */
public class ViewEmployer extends javax.swing.JDialog {

    /**
     * Creates new form ViewEmployer
     */
    private EmployerController empControl = new EmployerController();
    private JDialog parent;
    
    public ViewEmployer(int empid, JDialog parent) {
        super(parent, true);
        initComponents();
        
        this.parent = parent;
        Employer emp = empControl.getEmployerByID(empid);
        
        empName.setText(emp.getName());
        
        description.setText(emp.getDescription());
        description.getCaret().setVisible(false);
        StyledDocument styleddesc = description.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        styleddesc.setParagraphAttributes(0, styleddesc.getLength(), center, false);
        
        industry.setText(emp.getIndustry());
        phone.setText("     Phone: "+emp.getPhone());
        phone.setCaret(new DefaultCaret(){
            @Override
            public void paint(Graphics g) {
                //empty caret
            }
            
        });
        
        email.setText("     Email: "+emp.getEmail());
        email.setCaret(new DefaultCaret(){
            @Override
            public void paint(Graphics g) {
                //empty caret
            }
            
        });
        
//        contactPanel.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                super.mouseClicked(e);
//                phone.setFocusable(true); email.setFocusable(true);
//                phone.requestFocusInWindow(); email.requestFocusInWindow();
//            }
//            
//            
//            
//        });
        
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
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        empName = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        industry = new javax.swing.JLabel();
        contactPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        phone = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        email = new javax.swing.JTextArea();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(623, 593));
        setMinimumSize(new java.awt.Dimension(623, 593));
        setModal(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(623, 593));
        setResizable(false);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Employer Profile");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, 300, 60));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employer Name", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new java.awt.BorderLayout());

        empName.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        empName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empName.setText("Name");
        jPanel1.add(empName, java.awt.BorderLayout.CENTER);

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 100, 520, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new java.awt.BorderLayout());

        description.setEditable(false);
        description.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        description.setFocusable(false);
        description.setHighlighter(null);
        jScrollPane1.setViewportView(description);

        jPanel2.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 520, 120));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Industry", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(new java.awt.BorderLayout());

        industry.setFont(new java.awt.Font("Segoe UI", 0, 20)); // NOI18N
        industry.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        industry.setText("Industry");
        jPanel3.add(industry, java.awt.BorderLayout.CENTER);

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 320, 520, 60));

        contactPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contact", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        contactPanel.setLayout(new javax.swing.BoxLayout(contactPanel, javax.swing.BoxLayout.Y_AXIS));

        phone.setEditable(false);
        phone.setColumns(20);
        phone.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        phone.setRows(1);
        jScrollPane2.setViewportView(phone);

        contactPanel.add(jScrollPane2);

        email.setEditable(false);
        email.setColumns(20);
        email.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        email.setRows(1);
        jScrollPane3.setViewportView(email);

        contactPanel.add(jScrollPane3);

        panel.add(contactPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 400, 520, 80));

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
        panel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 500, 100, 40));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeButtonActionPerformed
        this.dispose();
    }//GEN-LAST:event_closeButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton closeButton;
    private javax.swing.JPanel contactPanel;
    private javax.swing.JTextPane description;
    private javax.swing.JTextArea email;
    private javax.swing.JLabel empName;
    private javax.swing.JLabel industry;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JPanel panel;
    private javax.swing.JTextArea phone;
    // End of variables declaration//GEN-END:variables
}
