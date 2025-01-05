package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.Placement;
import com.mycompany.internshipmanager.models.Student;
import java.awt.BorderLayout;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author Asus
 */
public class ViewInternship extends javax.swing.JDialog {

    private ViewInternshipsList dialog;
    private PlacementController plaControl;
    private StudentController stdControl;
    private InternshipController internControl;
    private JPanel panel;
    private Placement placement;
    private String type;
    
    
    public ViewInternship(ViewInternshipsList dia, int pla_id, String type) {
        super(dia, "View Internship", true);
        this.type = type;
        this.dialog = dia;
        this.plaControl = new PlacementController();
        this.placement = plaControl.getPlacementByID(pla_id);
        initComponents();        
        init();
        
    }
    
    private void init(){
        this.plaControl = new PlacementController();
        this.stdControl = new StudentController();
        this.internControl = new InternshipController();
        
        Student std = stdControl.getStudentByID(placement.getStd_id());
        Internship intern = internControl.getInternshipByID(placement.getInternship_id());
        
        setLayout(new MigLayout("fill")); //layout
        
        this.panel = new JPanel(new MigLayout("fill"));
        
        JPanel titlePanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        JPanel contentPanel = new JPanel(new MigLayout("fillx, wrap 1", "[]", "[]15[]"));
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[33%][33%][33%]"));
        
        JLabel title = new JLabel("Application");
        
        titlePanel.add(title, "cell 1 0, align center");
        
        JPanel namePanel = new JPanel(new BorderLayout());        
        namePanel.setBorder(BorderFactory.createTitledBorder("Student Name"));        
        JLabel name = new JLabel(std.getFirst_name() + " " + std.getLast_name());
        namePanel.add(name, BorderLayout.CENTER);
        contentPanel.add(namePanel, "growx, shrinkx");
        
        JPanel internshipPanel = new JPanel(new BorderLayout());        
        internshipPanel.setBorder(BorderFactory.createTitledBorder("Internship"));        
        JLabel internship = new JLabel(intern.getTitle());
        internshipPanel.add(internship, BorderLayout.CENTER);
        contentPanel.add(internshipPanel, "growx, shrinkx");
        
        JPanel datePanel = new JPanel(new BorderLayout());        
        datePanel.setBorder(BorderFactory.createTitledBorder("Start Date"));        
        JLabel date = new JLabel(placement.getStart_date());
        datePanel.add(date, BorderLayout.CENTER);
        contentPanel.add(datePanel, "growx, shrinkx");
        
        JPanel resumePanel = new JPanel(new BorderLayout());        
        resumePanel.setBorder(BorderFactory.createTitledBorder("End Date"));        
        JLabel end_date = new JLabel(placement.getEnd_date());
        resumePanel.add(end_date, BorderLayout.CENTER);
        contentPanel.add(resumePanel, "growx, shrinkx");
        
        JPanel statusPanel = new JPanel(new BorderLayout());        
        statusPanel.setBorder(BorderFactory.createTitledBorder("status"));        
        JLabel status = new JLabel(placement.getStatus());
        statusPanel.add(status, BorderLayout.CENTER);
        contentPanel.add(statusPanel, "growx, shrinkx");
        
        JPanel feedbackPanel = new JPanel(new BorderLayout());        
        feedbackPanel.setBorder(BorderFactory.createTitledBorder("Feedback"));        
        JLabel feedback = new JLabel(placement.getFeedback());
        feedbackPanel.add(feedback, BorderLayout.CENTER);
        contentPanel.add(feedbackPanel, "growx, shrinkx");
        
        //buttons
        JButton cancel = new JButton("Cancel Internship"){{
            addActionListener(e -> {
                plaControl.updatePlacement(placement.getPlacement_id(), String.valueOf(placement.getStd_id()), String.valueOf(intern.getId()), String.valueOf(placement.getEmp_id()),"Cancelled" , placement.getStart_date(), placement.getEnd_date(), placement.getFeedback());
                dialog.loadApplicationItems();                                                
                ViewInternship.this.dispose();
                
                
            });
        }};
        
        JButton uncancel = new JButton("Renew Internship"){{
            addActionListener(e -> {
                plaControl.updatePlacement(placement.getPlacement_id(), String.valueOf(placement.getStd_id()), String.valueOf(intern.getId()), String.valueOf(placement.getEmp_id()),"Ongoing" , placement.getStart_date(), placement.getEnd_date(), placement.getFeedback());
                dialog.loadApplicationItems();                                                
                ViewInternship.this.dispose();
                
                
            });
        }};
        
        JButton close = new JButton("Close"){{
            addActionListener(e-> {
                ViewInternship.this.dispose();
            });
        }};
                
        
        if (type.equals("Ongoing")){
            buttonPanel.add(cancel, "cell 0 0, align right");        
        } else if (type.equals("Cancelled")){
            buttonPanel.add(uncancel, "cell 0 0, align right");
        }
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
