package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.custom_ui.GlassPane;
import com.mycompany.internshipmanager.models.Employer;
import com.mycompany.internshipmanager.models.Internship;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/**
 *
 * @author Asus
 */
public class ViewInternship extends javax.swing.JDialog {

    /**
     * Creates new form ViewInternship
     */
    private EmployerController empControl = new EmployerController();
    private JFrame parent;    
    
    public ViewInternship(Internship intern, std_dashboard parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        this.parent = parent;
       
        
        Employer emp = empControl.getEmployerByID(intern.getEmp_id());
        
        titleLabel.setText(intern.getTitle());
        descLabel.setText(intern.getDescription());
        descLabel.getCaret().setVisible(false);
        StyledDocument styleddesc = descLabel.getStyledDocument();
        SimpleAttributeSet center = new SimpleAttributeSet();
        StyleConstants.setAlignment(center, StyleConstants.ALIGN_CENTER);
        styleddesc.setParagraphAttributes(0, styleddesc.getLength(), center, false);
        
        empLabel.setText(emp.getName());
        durationLabel.setText(String.valueOf(intern.getDuration()));
        statusLabel.setText(intern.getStatus());
        
        closeButton.addActionListener(e -> {
            ViewInternship.this.dispose();                    
        });
        
       applyButton.addActionListener(e -> {
           
           new ApplicationForm(this, parent.logged_std, intern.getId()).setVisible(true);     
           
       });
        
        setLocationRelativeTo(parent);
                
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosed(WindowEvent e) {
                super.windowClosed(e);
                parent.gp.setVisible(false);
                parent.loadApplications();
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

        panel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        descScroll = new javax.swing.JScrollPane();
        descLabel = new javax.swing.JTextPane();
        jPanel3 = new javax.swing.JPanel();
        empLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        durationLabel = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        statusLabel = new javax.swing.JLabel();
        buttonPanel = new javax.swing.JPanel();
        applyButton = new javax.swing.JButton();
        closeButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(676, 632));
        setResizable(false);

        panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setText("Internship");
        panel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 170, 62));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Title", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel1.setLayout(new java.awt.BorderLayout());

        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("Title");
        jPanel1.add(titleLabel, java.awt.BorderLayout.CENTER);

        panel.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 80, 580, 60));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Description", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel2.setLayout(new java.awt.BorderLayout());

        descLabel.setEditable(false);
        descLabel.setFocusable(false);
        descLabel.setHighlighter(null);
        descScroll.setViewportView(descLabel);

        jPanel2.add(descScroll, java.awt.BorderLayout.CENTER);

        panel.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 170, 580, 160));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Employer", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel3.setLayout(new java.awt.BorderLayout());

        empLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        empLabel.setText("Employer");
        jPanel3.add(empLabel, java.awt.BorderLayout.CENTER);

        panel.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, 580, 70));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Duration in Months", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel4.setLayout(new java.awt.BorderLayout());

        durationLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        durationLabel.setText("Duration");
        jPanel4.add(durationLabel, java.awt.BorderLayout.CENTER);

        panel.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, 580, 60));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Status", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));
        jPanel5.setLayout(new java.awt.BorderLayout());

        statusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        statusLabel.setText("Status");
        jPanel5.add(statusLabel, java.awt.BorderLayout.CENTER);

        panel.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 490, 580, 50));

        buttonPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        applyButton.setText("Apply");
        buttonPanel.add(applyButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 20, -1, -1));

        closeButton.setText("Close");
        buttonPanel.add(closeButton, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 20, -1, -1));

        panel.add(buttonPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 550, 580, 60));

        getContentPane().add(panel, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton applyButton;
    private javax.swing.JPanel buttonPanel;
    private javax.swing.JButton closeButton;
    private javax.swing.JTextPane descLabel;
    private javax.swing.JScrollPane descScroll;
    private javax.swing.JLabel durationLabel;
    private javax.swing.JLabel empLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel panel;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}