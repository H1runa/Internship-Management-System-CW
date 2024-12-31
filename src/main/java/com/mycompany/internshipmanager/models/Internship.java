package com.mycompany.internshipmanager.models;


public class Internship {
    private int id;
    private String title;
    private String description;
    private int emp_id;
    private int duration;
    private String status;
    
    public Internship(int id, String title, String desc, int emp_id, int dur, String stat){
        this.id = id;
        this.title = title;
        this.description = desc;
        this.emp_id = emp_id;
        this.duration = dur;
        this.status = stat;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
    
}
