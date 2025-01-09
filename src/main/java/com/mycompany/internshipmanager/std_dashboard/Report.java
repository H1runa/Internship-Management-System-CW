package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.DBConnection;
import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Student;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;



public class Report {
    private int std_id;
    private Student std;
    private ApplicationController applControl;
    private PlacementController plaControl;
    private StudentController stdControl;    
    
    public Report(int id){
        this.std_id = id;
        this.stdControl = new StudentController();
        this.applControl = new ApplicationController();
        this.plaControl = new PlacementController();
        
        generateReport();
    }
    
    
    
    public void generateReport(){
        Student std = stdControl.getStudentByID(std_id);
        Map<String, Object> params = new HashMap<>(); //getting the data for the report
        params.put("std_name", std.getFirst_name()+" "+std.getLast_name());                        
        params.put("internships_applied", applControl.getApplicationsSubmitted(std_id));
        params.put("internships_selected", applControl.getApplicationsAccepted(std_id));
        params.put("internships_rejected", applControl.getApplicationsRejected(std_id));
        params.put("internships_completed", plaControl.getInternshipsFinished(std_id));
        params.put("internships_ongoing", plaControl.getInternshipsOngoing(std_id));
        params.put("internships_cancelled", plaControl.getInternshipsCancelled(std_id));
        
        InputStream reportStream = Report.this.getClass().getResourceAsStream("/reports/InternshipsReport.jrxml");
        
        try{
            
            if (reportStream != null){
                JasperReport jasperReport = JasperCompileManager.compileReport(reportStream);        
                
                JRDataSource emptyDataSource = new JREmptyDataSource();
                                
                JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params, emptyDataSource);

                JasperViewer jasperViewer = new JasperViewer(jasperPrint, true); // false to not show export options
                jasperViewer.setVisible(true);
            } else {
                System.out.println("File not found");
            }

            
            
        } catch(JRException ex){
            System.out.println(ex.getMessage());
        }                
    }
    
    
    
}
