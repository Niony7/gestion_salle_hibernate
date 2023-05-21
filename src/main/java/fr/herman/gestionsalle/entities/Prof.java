package fr.herman.gestionsalle.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@Table(name = "Prof")
public class Prof implements Serializable {
    @Id
    private String codeprof;
    private String nom;
    private String prenom;
    private String grade;


    public Prof() {

    }
    public Prof(String codeprof, String nom, String prenom, String grade) {
        this.codeprof = codeprof;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    public String getCodeprof() {
        return codeprof;
    }

    public void setCodeprof(String codeprof) {
        this.codeprof = codeprof;
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

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Prof{" +
                "codeprof='" + codeprof + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", grade='" + grade + '\'' +
                '}';
    }
}
