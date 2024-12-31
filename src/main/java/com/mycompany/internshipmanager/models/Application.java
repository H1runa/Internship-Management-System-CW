package com.mycompany.internshipmanager.models;

public class Application {
    private int application_id;
    private int stu_id;
    private int internship_id;
    private String date;
    private String resume;
    private String status;

    public Application(int application_id, int stu_id, int internship_id, String date, String resume, String status) {
        this.application_id = application_id;
        this.stu_id = stu_id;
        this.internship_id = internship_id;
        this.date = date;
        this.resume = resume;
        this.status = status;
    }

    public int getApplication_id() {
        return application_id;
    }

    public void setApplication_id(int application_id) {
        this.application_id = application_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getInternship_id() {
        return internship_id;
    }

    public void setInternship_id(int internship_id) {
        this.internship_id = internship_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
