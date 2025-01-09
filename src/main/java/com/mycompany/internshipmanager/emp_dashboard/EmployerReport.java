package com.mycompany.internshipmanager.emp_dashboard;

import com.mycompany.internshipmanager.DBConnection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JDialog;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;


public class EmployerReport {
    private int emp_id;
    private JDialog parent;
    public EmployerReport(int id, JDialog parent){
        this.emp_id = id;
        this.parent = parent;
        
        generateReport();
    }
    
    
    private void generateReport(){
        try{
            JasperReport report = (JasperReport)JRLoader.loadObject(EmployerReport.class.getResourceAsStream("/reports/EmployerReport.jasper"));
             
            //adding params
            Map<String, Object> params = new HashMap<>();
            params.put("emp_ID", emp_id);
            
            //displaying report
            JasperPrint jasPrint = JasperFillManager.fillReport(report, params, DBConnection.getConnection());
            JasperViewer jasView = new JasperViewer(jasPrint, true);
            
            JDialog frame = new JDialog(parent, true);
            
//            frame.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
            frame.getContentPane().add(jasView.getContentPane());
            frame.setSize(1000,800);
            frame.setLocationRelativeTo(parent);
            //frame.pack();
            frame.setAlwaysOnTop(true);
            frame.setVisible(true);
            
             
            
        } catch (JRException ex){
            System.out.println("Jasper Report Error");
        }
    }
}
