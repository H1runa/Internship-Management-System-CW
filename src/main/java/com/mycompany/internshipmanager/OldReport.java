package com.mycompany.internshipmanager;

import java.io.InputStream;

public class OldReport {
    
    private static OldReport instance;

    
    private OldReport() {
    }

    
    public static synchronized OldReport getInstance() {
        if (instance == null) {
            instance = new OldReport();
        }
        return instance;
    }
    
    public static InputStream getInternshipReport() {        
        InputStream reportStream = OldReport.getInstance().getClass().getResourceAsStream("/reports/InternshipsReport.jrxml");

        if (reportStream == null) {
            System.out.println("JRXML file not retrieved");
        } else {
            System.out.println("Report Stream returned");
        }

        return reportStream;
    }
}
