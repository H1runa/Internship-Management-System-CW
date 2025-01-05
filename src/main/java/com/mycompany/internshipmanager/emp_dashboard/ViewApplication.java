package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Application;
import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.Student;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class ViewApplication extends javax.swing.JDialog {

    /**
     * Creates new form ViewApplication
     */
    private ApplicationController appl_control;
    private Application appl;
    private StudentController stdControl;
    private Student std;
    private InternshipController iControl;
    private Internship intern;
    private ViewApplicationsList dialog;
    private JPanel panel;
    
    public ViewApplication(ViewApplicationsList dia, int appl_id) {
        super(dia, "ViewApplication", true);
        this.dialog = dia;        
        this.appl_control = new ApplicationController();
        this.appl = appl_control.getApplicationByID(appl_id);
        
        initComponents();
        
        init();
    }
    
    private void init(){
        this.stdControl = new StudentController();
        this.std = stdControl.getStudentByID(appl.getStu_id());
        this.iControl = new InternshipController();
        this.intern = iControl.getInternshipByID(appl.getInternship_id());        
        
        setLayout(new MigLayout("fill")); //layout
        
        this.panel = new JPanel(new MigLayout("fill"));
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        JPanel contentPanel = new JPanel(new MigLayout("fillx, wrap 1", "[]", "[]15[]"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        
        JLabel title = new JLabel("Application");
        
        titlePanel.add(title, "cell 1 0, align center");
        
        JPanel namePanel = new JPanel(new BorderLayout());        
        namePanel.setBorder(BorderFactory.createTitledBorder("Full Name"));        
        JLabel name = new JLabel(std.getFirst_name() + " " + std.getLast_name());
        namePanel.add(name, BorderLayout.CENTER);
        contentPanel.add(namePanel, "growx, shrinkx");
        
        JPanel internshipPanel = new JPanel(new BorderLayout());        
        internshipPanel.setBorder(BorderFactory.createTitledBorder("Internship"));        
        JLabel internship = new JLabel(intern.getTitle());
        internshipPanel.add(internship, BorderLayout.CENTER);
        contentPanel.add(internshipPanel, "growx, shrinkx");
        
        JPanel datePanel = new JPanel(new BorderLayout());        
        datePanel.setBorder(BorderFactory.createTitledBorder("Date Submitted"));        
        JLabel date = new JLabel(appl.getDate());
        datePanel.add(date, BorderLayout.CENTER);
        contentPanel.add(datePanel, "growx, shrinkx");
        
        JPanel resumePanel = new JPanel(new BorderLayout());        
        resumePanel.setBorder(BorderFactory.createTitledBorder("Link to Resume"));        
        JLabel resume = new JLabel(appl.getResume());
        resumePanel.add(resume, BorderLayout.CENTER);
        contentPanel.add(resumePanel, "growx, shrinkx");
        
        JPanel statusPanel = new JPanel(new BorderLayout());        
        statusPanel.setBorder(BorderFactory.createTitledBorder("status"));        
        JLabel status = new JLabel(appl.getStatus());
        statusPanel.add(status, BorderLayout.CENTER);
        contentPanel.add(statusPanel, "growx, shrinkx");
        
        //buttons
        JButton accept = new JButton("Accept"){{
            addActionListener(e -> {
                appl_control.updateApplication(appl.getApplication_id(), String.valueOf(appl.getStu_id()), String.valueOf(appl.getInternship_id()), appl.getDate(), appl.getResume(), "Accepted");                
                dialog.loadApplicationItems();
                ViewApplication.this.dispose();
                
                
            });
        }};
        JButton reject = new JButton("Reject"){{
            addActionListener(e -> {
                appl_control.updateApplication(appl.getApplication_id(), String.valueOf(appl.getStu_id()), String.valueOf(appl.getInternship_id()), appl.getDate(), appl.getResume(), "Rejected");                
                dialog.loadApplicationItems();
                ViewApplication.this.dispose();
                
            });
        }};
        
        JButton close = new JButton("Close"){{
            addActionListener(e-> {
                ViewApplication.this.dispose();
            });
        }};
                
        
        
        buttonPanel.add(accept, "cell 0 0, align right");
        buttonPanel.add(reject, "cell 1 0, align center");
        buttonPanel.add(close, "cell 2 0, align left");
        
        
        panel.add(contentPanel, "dock center");
        panel.add(buttonPanel, "dock south");
        add(panel, "grow");
        
        setSize(600, 400);
        setLocationRelativeTo(dialog);
        setUndecorated(true);
        setVisible(true);   
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
