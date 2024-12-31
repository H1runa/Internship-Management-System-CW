package com.mycompany.internshipmanager.models;

public class Placement {
    private int placement_id;
    private int std_id;
    private int internship_id;
    private int emp_id;
    private String status;
    private String start_date;
    private String end_date;
    private String feedback;

    public Placement(int placement_id, int std_id, int internship_id, int emp_id, String status, String start_date, String end_date, String feedback) {
        this.placement_id = placement_id;
        this.std_id = std_id;
        this.internship_id = internship_id;
        this.emp_id = emp_id;
        this.status = status;
        this.start_date = start_date;
        this.end_date = end_date;
        this.feedback = feedback;
    }

    public int getPlacement_id() {
        return placement_id;
    }

    public void setPlacement_id(int placement_id) {
        this.placement_id = placement_id;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public int getInternship_id() {
        return internship_id;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
    
    
}
