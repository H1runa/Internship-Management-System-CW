/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.internshipmanager.models;

/**
 *
 * @author Asus
 */
public class Student {
    private int std_id;
    private String first_name;
    private String last_name;
    private String dob;
    private String email;
    private String phone;
    private String department;
    private int yearOfStudy;
    
    public Student(int id, String first_name, String last_name,String dob,String email,String phone,String dep,int yos){
        this.std_id = id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.dob = dob;
        this.department = dep;
        this.yearOfStudy = yos;
        this.email = email;
        this.phone = phone;
    }

    public int getStd_id() {
        return std_id;
    }

    public void setStd_id(int std_id) {
        this.std_id = std_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getYearOfStudy() {
        return yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    
    
    
    
}
