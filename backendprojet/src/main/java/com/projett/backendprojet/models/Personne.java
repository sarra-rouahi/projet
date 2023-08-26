package com.projett.backendprojet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.List;


@Entity
public class Personne {
    @Id
    @GeneratedValue
    private int id;
    private String nom;
    private String prenom;
    private String profession;
    private String email;
    private String motdepasse;
    public Personne() {
    }

    public Personne(int id, String nom, String prenom, String profession, String email,String motdepasse) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.profession = profession;
        this.email = email;
        this.motdepasse=motdepasse;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Personne{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", profession='" + profession + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
