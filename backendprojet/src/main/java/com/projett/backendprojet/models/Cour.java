package com.projett.backendprojet.models;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ext.SqlBlobSerializer;
import jakarta.persistence.*;

import java.sql.Blob;
@Entity

public class Cour {

    @Id
    @GeneratedValue
    private int num;
    @ManyToOne
    private Matiere matiere;
    private String nom;

@Lob
private Blob piecejointe;




    public Cour(int num, Matiere matiere, String nom, Blob piecejointe) {
        this.num = num;
        this.matiere = matiere;
        this.nom = nom;
        this.piecejointe = piecejointe;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Cour() {
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Blob getPiecejointe() {
        return piecejointe;
    }

    public void setPiecejointe(Blob piecejointe) {
        this.piecejointe = piecejointe;
    }

    @Override
    public String toString() {
        return "Cour{" +
                "num=" + num +
                ", nom='" + nom + '\'' +
                ", piecejointe=" + piecejointe +
                '}';
    }
}
