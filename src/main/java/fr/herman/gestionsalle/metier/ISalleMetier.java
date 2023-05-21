package fr.herman.gestionsalle.metier;


import fr.herman.gestionsalle.entities.Salle;

import java.util.List;

public interface ISalleMetier {
    public Salle saveSalle(Salle salle);
    public Salle updateSalle(Salle salle);
    Salle getSalle(String codesalle);

    public List<Salle> getAllSalle();
    public List<Salle> searchSalle(String motcle);
    public boolean deleteSalle(Salle salle);


}
