package com.projett.backendprojet.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Matiere {
    @Id
    @GeneratedValue
    private int code;
     private  String nom;
     private String motcle;
    @OneToMany
     private List<Cour> listedecours;

    public Matiere() {
    }


    public List<Cour> getListedecours() {
        return listedecours;
    }

    public void setListedecours(List<Cour> listedecours) {
        this.listedecours = listedecours;
    }

    public Matiere(int code, String nom, String motcle, List<Cour> listedecours) {
        this.code = code;
        this.nom = nom;
        this.motcle = motcle;
        this.listedecours = listedecours;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getMotcle() {
        return motcle;
    }

    public void setMotcle(String motcle) {
        this.motcle = motcle;
    }

    @Override
    public String toString() {
        return "Matiere{" +
                "code=" + code +
                ", nom='" + nom + '\'' +
                ", motcle='" + motcle + '\'' +
                ", listedecours=" + listedecours +
                '}';
    }
}
