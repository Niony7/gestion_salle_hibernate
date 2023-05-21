package fr.herman.gestionsalle.metier;

import fr.herman.gestionsalle.entities.Prof;
import javafx.print.Collation;

import java.util.List;

public interface IProfMetier {
    public Prof saveProf(Prof prof);
    public Prof updateProf(Prof prof);
    public Prof getProf(String codeprof);
    public List<Prof> getAllProf();
    public List<Prof> searchProf(String motcle);
    public boolean deleteProf(Prof prof);

}
