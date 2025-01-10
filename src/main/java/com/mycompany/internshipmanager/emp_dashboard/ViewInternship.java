package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.Placement;
import com.mycompany.internshipmanager.models.Student;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
        JPanel buttonPanel = new JPanel(new MigLayout("fillx", "[25%][25%][25%][25%]"));
        
        JLabel title = new JLabel("Application");
        
        titlePanel.add(title, "cell 1 0, align center");
        
        JPanel namePanel = new JPanel(new BorderLayout());        
        namePanel.setBorder(BorderFactory.createTitledBorder("Student Name"));        
        JLabel name = new JLabel(std.getFirst_name() + " " + std.getLast_name());
        name.setFont(name.getFont().deriveFont(18f));
        namePanel.add(name, BorderLayout.CENTER);
        contentPanel.add(namePanel, "growx, shrinkx");
        namePanel.setBackground(Color.decode("#484848"));
        namePanel.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                namePanel.setBackground(Color.decode("#585858"));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                namePanel.setBackground(Color.decode("#484848"));
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                new ViewStudent(ViewInternship.this, std.getStd_id()).setVisible(true);
            }
            
            
        });
        
        JPanel internshipPanel = new JPanel(new BorderLayout());        
        internshipPanel.setBorder(BorderFactory.createTitledBorder("Internship"));        
        JLabel internship = new JLabel(intern.getTitle());
        internship.setFont(internship.getFont().deriveFont(18f));
        internshipPanel.add(internship, BorderLayout.CENTER);
        contentPanel.add(internshipPanel, "growx, shrinkx");
        
        JPanel datePanel = new JPanel(new BorderLayout());        
        datePanel.setBorder(BorderFactory.createTitledBorder("Start Date"));        
        JLabel date = new JLabel(placement.getStart_date());
        date.setFont(date.getFont().deriveFont(18f));
        datePanel.add(date, BorderLayout.CENTER);
        contentPanel.add(datePanel, "growx, shrinkx");
        
        JPanel resumePanel = new JPanel(new BorderLayout());        
        resumePanel.setBorder(BorderFactory.createTitledBorder("End Date"));        
        JLabel end_date = new JLabel(placement.getEnd_date());
        end_date.setFont(end_date.getFont().deriveFont(18f));
        resumePanel.add(end_date, BorderLayout.CENTER);
        contentPanel.add(resumePanel, "growx, shrinkx");
        
        JPanel statusPanel = new JPanel(new BorderLayout());        
        statusPanel.setBorder(BorderFactory.createTitledBorder("status"));        
        JLabel status = new JLabel(placement.getStatus());
        status.setFont(status.getFont().deriveFont(18f));
        statusPanel.add(status, BorderLayout.CENTER);
        contentPanel.add(statusPanel, "growx, shrinkx");
        
//        JPanel feedbackPanel = new JPanel(new BorderLayout());        
//        feedbackPanel.setBorder(BorderFactory.createTitledBorder("Feedback"));        
//        JLabel feedback = new JLabel(placement.getFeedback());
//        feedbackPanel.add(feedback, BorderLayout.CENTER);
//        contentPanel.add(feedbackPanel, "growx, shrinkx");
        
        //buttons
        Dimension buttonSize = new Dimension(80,30);
        JButton cancel = new JButton("Cancel Internship"){{
            addActionListener(e -> {
                int choice = JOptionPane.showConfirmDialog(ViewInternship.this, "Cancel this internship?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION){
                    plaControl.updatePlacement(placement.getPlacement_id(), String.valueOf(placement.getStd_id()), String.valueOf(intern.getId()), String.valueOf(placement.getEmp_id()),"Cancelled" , placement.getStart_date(), placement.getEnd_date(), placement.getFeedback());
                    dialog.loadApplicationItems();                                                
                    ViewInternship.this.dispose();
                }                                
            });
        }};
        cancel.setSize(buttonSize);
        cancel.setFont(cancel.getFont().deriveFont(18f));
        
        JButton uncancel = new JButton("Renew Internship"){{
            addActionListener(e -> {
                int choice = JOptionPane.showConfirmDialog(ViewInternship.this, "Renew the internship?", "Confirmation", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (choice == JOptionPane.YES_OPTION){
                    plaControl.updatePlacement(placement.getPlacement_id(), String.valueOf(placement.getStd_id()), String.valueOf(intern.getId()), String.valueOf(placement.getEmp_id()),"Ongoing" , placement.getStart_date(), placement.getEnd_date(), placement.getFeedback());
                    dialog.loadApplicationItems();                                                
                    ViewInternship.this.dispose();
                }                                
            });
        }};
        uncancel.setSize(buttonSize);
        uncancel.setFont(uncancel.getFont().deriveFont(18f));
        
        JButton close = new JButton("Close"){{
            addActionListener(e-> {
                ViewInternship.this.dispose();
            });
        }};
        close.setSize(buttonSize);
        close.setFont(close.getFont().deriveFont(18f));
                
        
        if (type.equals("Ongoing")){
            buttonPanel.add(cancel, "cell 1 0, align right");        
        } else if (type.equals("Cancelled")){
            buttonPanel.add(uncancel, "cell 1 0, align right");
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
