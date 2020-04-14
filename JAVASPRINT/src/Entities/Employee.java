/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

/**
 *
 * @author khaoula
 */
import java.sql.Date;

public class Employee {
    private int id, user_id, admin_id;
    private String fonction, Name, Last_name,image, email;
    private Date Birth_Date;

    public Employee(int id, String fonction, String Name, String Last_name, String image, Date Birth_Date, String email) {
        this.id = id;
        this.fonction = fonction;
        this.Name = Name;
        this.Last_name = Last_name;
        this.image = image;
       
        this.Birth_Date = Birth_Date;
         this.email=email;
    }

    public Employee(int id, String Name) {
        this.id = id;
        this.Name = Name;
    }
    

    public Employee(int id, int user_id, int admin_id, String fonction, String Name, String Last_name, String image, Date Birth_Date) {
        this.id = id;
        this.user_id = user_id;
        this.admin_id = admin_id;
        this.fonction = fonction;
        this.Name = Name;
        this.Last_name = Last_name;
        this.image = image;
        this.Birth_Date = Birth_Date;
    }

    public Employee() {
    }

    public Employee(int id, String fonction, String Name, String Last_name, Date Birth_Date, String image, String email) {
        this.id = id;
        this.fonction = fonction;
        this.Name = Name;
        this.Last_name = Last_name;
        this.Birth_Date = Birth_Date;
        this.image = image;
        this.email = email;
        
    }

   

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getLast_name() {
        return Last_name;
    }

    public void setLast_name(String Last_name) {
        this.Last_name = Last_name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Date getBirth_Date() {
        return Birth_Date;
    }

    public void setBirth_Date(Date Birth_Date) {
        this.Birth_Date = Birth_Date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", user_id=" + user_id + ", admin_id=" + admin_id + ", fonction=" + fonction + ", Name=" + Name + ", Last_name=" + Last_name + ", image=" + image + ", email=" + email + ", Birth_Date=" + Birth_Date + '}';
    }

	
    
}
