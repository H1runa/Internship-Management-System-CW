package com.mycompany.internshipmanager;

import com.mycompany.internshipmanager.models.Employer;

//singleton class to track the logged in user (Employer)

public class LoggedEmployer {
    private static LoggedEmployer instance;
    private Employer emp;
    
    private LoggedEmployer(){};
    
    public static LoggedEmployer getInstance(){
        if (instance == null){
            instance = new LoggedEmployer();
        }
        return instance;
    }
    
    public void setEmployer(Employer emp){
        this.emp = emp;
    }
    
    public Employer getEmployer(){
        return this.emp;
    }
    
    public void clear(){
        this.emp = null;
    }
}
