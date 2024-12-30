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
        
        StudentController ctrl = new StudentController();        
//        ctrl.addStudent("Shoto", "todoroki456@gmail.com", "0112409190");
//        viewStudent(ctrl.getStudentByID(3));
//        ctrl.getStudents().forEach(a -> {viewStudent(a);});
        ctrl.deleteStudent(3);
//        ctrl.deleteAll();
        
    }
    
    public static void viewStudent(Student std){
        System.out.println("");
        System.out.println(std.getStd_id());
        System.out.println(std.getName());
        System.out.println(std.getEmail());
        System.out.println(std.getPhone());
        System.out.println(""); //line break for mulitple students
    }
}
