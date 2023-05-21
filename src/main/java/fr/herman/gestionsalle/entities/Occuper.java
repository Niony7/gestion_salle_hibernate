package fr.herman.gestionsalle.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Occuper implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
     @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
     @JoinColumn(name="codeprof")
    private Prof prof;
    @ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
     @JoinColumn(name ="codesal")
    private Salle salle;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Occuper() {
        super();
    }

    public Occuper(Prof prof, Salle salle, Date date) {
        this.prof = prof;
        this.salle = salle;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Prof getProf() {
        return prof;
    }

    public void setProf(Prof prof) {
        this.prof = prof;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Occuper{" +
                "id=" + id +
                ", prof=" + prof +
                ", salle=" + salle +
                ", date=" + date +
                '}';
    }
}
