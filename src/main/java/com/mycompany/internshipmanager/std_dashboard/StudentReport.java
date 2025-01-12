package com.mycompany.internshipmanager.std_dashboard;

import com.mycompany.internshipmanager.DBConnection;
import com.mycompany.internshipmanager.controllers.ApplicationController;
import com.mycompany.internshipmanager.controllers.PlacementController;
import com.mycompany.internshipmanager.controllers.StudentController;
import com.mycompany.internshipmanager.models.Student;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;



public class StudentReport {
    private int std_id;      
    private JDialog parent;
    
    public StudentReport(int id, JDialog parent){
        this.std_id = id;        
        this.parent = parent;
        
        generateReport();                
    }
    
    
    
    private void generateReport(){
        
        try{
            JasperReport report = (JasperReport)JRLoader.loadObject(StudentReport.class.getResourceAsStream("/reports/StudentReport.jasper"));
            
            //adding params
            Map<String, Object> params = new HashMap<>(); //getting the data for the report        
            params.put("std_ID", std_id);
            
            //displaying report
            JasperPrint jasPrint = JasperFillManager.fillReport(report, params, DBConnection.getConnection());
            JasperViewer jasView = new JasperViewer(jasPrint, true);
            
            JDialog frame = new JDialog(parent, true);
            
            frame.getContentPane().add(jasView.getContentPane());
            frame.setSize(1000,800);
            frame.setLocationRelativeTo(parent);
            
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);
            
            
        } catch (JRException ex){
            System.out.println("Jasper Report Error");
        }      
    }
}
