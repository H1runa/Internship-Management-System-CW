package com.mycompany.internshipmanager.models;


public class Employer {
    private int emp_id;
    private String name;
    private String email;
    private String phone;
    
    public Employer(int id, String name, String email, String phone){
        this.emp_id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
    
    
}
