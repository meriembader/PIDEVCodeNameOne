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
public class association {
    
    int id; 
    String raisonSociale;
    String Address; 
    int telephone;
    String domaine; 
    String gouvernorat;

    public association(int id, String raisonSociale, String Address, int telephone, String domaine, String gouvernorat) {
        this.id = id;
        this.raisonSociale = raisonSociale;
        this.Address = Address;
        this.telephone = telephone;
        this.domaine = domaine;
        this.gouvernorat = gouvernorat;
    }

    public association(String raisonSociale, String Address, int telephone, String domaine, String gouvernorat) {
        this.raisonSociale = raisonSociale;
        this.Address = Address;
        this.telephone = telephone;
        this.domaine = domaine;
        this.gouvernorat = gouvernorat;
    }

    public association() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getraisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public int getTelephone() {
        return telephone;
    }

    public void setTelephone(int telephone) {
        this.telephone = telephone;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
    }

    public String getGouvernorat() {
        return gouvernorat;
    }

    public void setGouvernorat(String gouvernorat) {
        this.gouvernorat = gouvernorat;
    }

    @Override
    public String toString() {
        return "association{" + "id=" + id + ", raisonSociale=" + raisonSociale + ", Address=" + Address + ", telephone=" + telephone + ", domaine=" + domaine + ", gouvernorat=" + gouvernorat + '}';
    }

  
    
    
    
}
