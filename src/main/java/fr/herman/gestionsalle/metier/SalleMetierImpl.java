package fr.herman.gestionsalle.metier;


import fr.herman.gestionsalle.dao.SalleDao;
import fr.herman.gestionsalle.entities.Salle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.List;
@Component
public class SalleMetierImpl implements ISalleMetier{
    @Autowired
    SalleDao salleDao;

    @Override
    public Salle saveSalle(Salle salle) {
        return salleDao.save(salle);
    }

    @Override
    public Salle updateSalle(Salle salle) {
        return salleDao.save(salle);
    }

    @Override
    public Salle getSalle(String codesalle) {
        return salleDao.getById(codesalle);
    }

    @Override
    public List<Salle> getAllSalle() {
        return salleDao.findAll();
    }

    @Override
    public List<Salle> searchSalle(String motcle) {
        return null;
    }

    @Override
    public boolean deleteSalle(Salle salle) {
        try{
            salleDao.delete(salle);
            return true;
        }catch (Exception e){
            return false;
        }

    }



}
