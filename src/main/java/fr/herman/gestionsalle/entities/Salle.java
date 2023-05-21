package fr.herman.gestionsalle.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class Salle implements Serializable {
    @Id
    private String codesal;
    private String designation;
    public Salle() {
    }
    /*constructor avec paramettre*/
    public Salle(String codesal, String designation) {
        this.codesal = codesal;
        this.designation = designation;
    }
    /*getter and setter*/
    public String getCodesal() {
        return codesal;
    }

    public void setCodesal(String codesal) {
        this.codesal = codesal;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Salle{" +
                "codesal='" + codesal + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
