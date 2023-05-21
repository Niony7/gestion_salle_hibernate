package fr.herman.gestionsalle.metier;

import fr.herman.gestionsalle.entities.Occuper;
import fr.herman.gestionsalle.entities.Prof;

import java.util.List;

public interface IOccuperMetier {
    public Occuper saveOccuper(Occuper occuper);
    public Occuper updateOccuper(Occuper occuper);
    public Occuper getOccuper(Integer id);
    public List<Occuper> getAllOccuper();
    public List<Occuper> searchOccuper(String motcle);
    public boolean deleteOccuper(Occuper occuper);

}
