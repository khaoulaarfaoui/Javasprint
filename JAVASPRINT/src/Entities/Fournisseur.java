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

public class Fournisseur {
 private int id, admin_id, numsociete; 
 private String societe,secteur,Name, Last_name,image;
 private Date Entreprise_Date;

    public Fournisseur(int id, int numsociete, String societe, String secteur, String Name, String Last_name, String image, Date Entreprise_Date) {
        this.id = id;
        this.numsociete = numsociete;
        this.societe = societe;
        this.secteur = secteur;
        this.Name = Name;
        this.Last_name = Last_name;
        this.image = image;
        this.Entreprise_Date = Entreprise_Date;
    }

    public Fournisseur(int id, int numsociete) {
        this.id = id;
        this.numsociete = numsociete;
    }

    public Fournisseur() {
    }

    
    public Fournisseur(int id, int admin_id, int numsociete, String societe, String secteur, String Name, String Last_name, String image, Date Entreprise_Date) {
        this.id = id;
        this.admin_id = admin_id;
        this.numsociete = numsociete;
        this.societe = societe;
        this.secteur = secteur;
        this.Name = Name;
        this.Last_name = Last_name;
        this.image = image;
        this.Entreprise_Date = Entreprise_Date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAdmin_id() {
        return admin_id;
    }

    public void setAdmin_id(int admin_id) {
        this.admin_id = admin_id;
    }

    public int getNumsociete() {
        return numsociete;
    }

    public void setNumsociete(int numsociete) {
        this.numsociete = numsociete;
    }

    public String getSociete() {
        return societe;
    }

    public void setSociete(String societe) {
        this.societe = societe;
    }

    public String getSecteur() {
        return secteur;
    }

    public void setSecteur(String secteur) {
        this.secteur = secteur;
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

    public Date getEntreprise_Date() {
        return Entreprise_Date;
    }

    public void setEntreprise_Date(Date Entreprise_Date) {
        this.Entreprise_Date = Entreprise_Date;
    }





}
