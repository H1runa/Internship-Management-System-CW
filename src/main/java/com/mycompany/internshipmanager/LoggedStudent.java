package com.mycompany.internshipmanager;

import com.mycompany.internshipmanager.models.Student;

//singleton class to track the logged in user (student)

public class LoggedStudent {
    private static LoggedStudent instance;
    private Student std;
    
    private LoggedStudent(){};
    
    public static LoggedStudent getInstance(){
        if (instance == null){
            instance = new LoggedStudent();
        }
        return instance;
    }
    
    public void setStudent(Student std){
        this.std = std;
    }
    
    public Student getStudent(){
        return this.std;
    }
    
    public void clear(){
        this.std = null;
    }
}
