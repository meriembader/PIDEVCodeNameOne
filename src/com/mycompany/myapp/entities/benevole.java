/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

/**
 *
 * @author Meriem
 */
public class benevole {
    
    int id; 
    int cin;
    String address;
    String mail;
    int telephone;
    String niveau;
    String gouvernorat;
    
    public benevole(){
    }

    public benevole(int cin, String address, String mail, int telephone, String niveau, String gouvernorat) {
        this.cin = cin;
        this.address = address;
        this.mail = mail;
        this.telephone = telephone;
        this.niveau = niveau;
        this.gouvernorat = gouvernorat;
    }

    public benevole(int id, int cin, String address, String mail, int telephone, String niveau, String gouvernorat) {
        this.id = id;
        this.cin = cin;
        this.address = address;
        this.mail = mail;
        this.telephone = telephone;
        this.niveau = niveau;
        this.gouvernorat = gouvernorat;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }
    
       @Override
    public String toString() {
        return "Benevole{" + "id=" + id + ", cin=" + cin + ", address=" + address + ", mail=" + mail + ", telephone=" + telephone + ", niveau=" + niveau + ", gouvernorat=" + gouvernorat + '}';
    }
    
}
