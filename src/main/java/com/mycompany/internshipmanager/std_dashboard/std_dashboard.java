package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.DBConnection;
import com.mycompany.internshipmanager.Login;
import com.mycompany.internshipmanager.OldReport;
import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.EmployerController;
import com.mycompany.internshipmanager.controllers.InternshipController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.custom_ui.GlassPane;
import com.mycompany.internshipmanager.emp_dashboard.emp_dashboard;
import com.mycompany.internshipmanager.models.Application;
import com.mycompany.internshipmanager.models.Internship;
import com.mycompany.internshipmanager.models.Placement;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import net.miginfocom.swing.MigLayout;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Asus
 */
public class std_dashboard extends javax.swing.JFrame {

    /**
     * Creates new form std_dashboard
     */
    public int logged_std;
    public GlassPane gp;
    
    private StudentController stdControl = new StudentController();
    private InternshipController internControl = new InternshipController();
    private PlacementController plaControl = new PlacementController();
    private EmployerController empControl = new EmployerController();
    private ApplicationController applControl = new ApplicationController();
    
    public std_dashboard(int id) {
        this.logged_std = id;
        
        initComponents();
        
        this.gp = new GlassPane(this); //setting up the glass pane
        setGlassPane(gp); gp.setVisible(false);
        
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        
        internshipPane.setLayout(new MigLayout("fillx, flowy, debug"));        
        applicationPane.setLayout(new MigLayout("fillx, flowy"));
        findPane.setLayout(new MigLayout("fillx, flowy"));
        loadPlacements();
        loadApplications();
        loadInternships();
        
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e) {
                 String[] options = {"Exit", "Logout"};                
                int choice = JOptionPane.showOptionDialog(std_dashboard.this, "What would you like to do?", "", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                if (choice == 0){
                    System.exit(0);
                } else if(choice == 1){
                    new Login().setVisible(true);
                    std_dashboard.this.dispose();                    
                }
            }
            
        });
        
    }
    
    public void loadPlacements(){                
        internshipPane.removeAll();
        List<Placement> plaList = plaControl.getPlacements();
        for (Placement p: plaList){
            if(p.getStd_id() == logged_std){
                internshipPane.add(new PlacementItem(empControl.getEmployerByID(p.getEmp_id()), internControl.getInternshipByID(p.getInternship_id()), p, std_dashboard.this));                
//                System.out.println("added");
            }
        }
        revalidate(); repaint();
        
    }
    
    public void loadApplications(){
        applicationPane.removeAll();
        List<Application> applList = applControl.getApplications();
        for (Application a: applList){
            if(a.getStu_id() == logged_std){
                applicationPane.add(new ApplicationItem(internControl.getInternshipByID(a.getInternship_id()), a, std_dashboard.this));
            }
        }
        revalidate(); repaint();
    }
    
    
    public void loadInternships(){
        findPane.removeAll();
        List<Internship> internList = internControl.getInternships();
        for (Internship i : internList){
            if (i.getStatus().equals("Open")){
                findPane.add(new InternshipItem(i, std_dashboard.this));
            }
        }
        revalidate(); repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background_panel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        tabbedPane = new javax.swing.JTabbedPane();
        applicationScoll = new javax.swing.JScrollPane();
        applicationPane = new javax.swing.JPanel();
        findScroll = new javax.swing.JScrollPane();
        findPane = new javax.swing.JPanel();
        myInternships = new javax.swing.JScrollPane();
        internshipPane = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        background_panel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        title.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        title.setText("Student Dashboard");
        background_panel.add(title, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 330, 70));

        javax.swing.GroupLayout applicationPaneLayout = new javax.swing.GroupLayout(applicationPane);
        applicationPane.setLayout(applicationPaneLayout);
        applicationPaneLayout.setHorizontalGroup(
            applicationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        applicationPaneLayout.setVerticalGroup(
            applicationPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        applicationScoll.setViewportView(applicationPane);

        tabbedPane.addTab("My Applications", applicationScoll);

        javax.swing.GroupLayout findPaneLayout = new javax.swing.GroupLayout(findPane);
        findPane.setLayout(findPaneLayout);
        findPaneLayout.setHorizontalGroup(
            findPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        findPaneLayout.setVerticalGroup(
            findPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        findScroll.setViewportView(findPane);

        tabbedPane.addTab("Find Internships", findScroll);

        myInternships.setViewportView(internshipPane);

        javax.swing.GroupLayout internshipPaneLayout = new javax.swing.GroupLayout(internshipPane);
        internshipPane.setLayout(internshipPaneLayout);
        internshipPaneLayout.setHorizontalGroup(
            internshipPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 624, Short.MAX_VALUE)
        );
        internshipPaneLayout.setVerticalGroup(
            internshipPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 269, Short.MAX_VALUE)
        );

        myInternships.setViewportView(internshipPane);

        tabbedPane.addTab("My Internships", myInternships);

        background_panel.add(tabbedPane, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 630, 310));

        getContentPane().add(background_panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 760, 500));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel applicationPane;
    private javax.swing.JScrollPane applicationScoll;
    private javax.swing.JPanel background_panel;
    private javax.swing.JPanel findPane;
    private javax.swing.JScrollPane findScroll;
    private javax.swing.JPanel internshipPane;
    private javax.swing.JScrollPane myInternships;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
