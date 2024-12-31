package com.mycompany.internshipmanager;

import com.mycompany.internshipmanager.models.*;
import com.mycompany.internshipmanager.controllers.*;
import java.sql.*;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Main {

    public static void main(String[] args) {
        
        //making sure the database conn is closed when exiting the application
        Runtime.getRuntime().addShutdownHook(new Thread(() -> 
        {
            DBConnection.closeConnection();
                }
            )
        );
                                       
        StudentController c = new StudentController();
        
//        c.addStudent("Ransilu", "IDFK", "2004-06-01", "weidshlatt@gmail.com", "0112409190", "Software", 2);
//        viewStudent(c.getStudentByID(1));
//        c.updateStudent(5, "Vidu", "Uknown", "2003-12-15", "whotfknow@gmail.com", "0221456789", "Software", 0);
//        c.deleteStudent(2);
//        c.getStudents().forEach(a->{viewStudent(a);});
        
        
    }
    
    public static void viewStudent(Student s){
        System.out.println("");
        System.out.println(s.getFirst_name());
        System.out.println(s.getLast_name());
        System.out.println(s.getDob());
        System.out.println("");
    }
}
