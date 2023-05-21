package fr.herman.gestionsalle.metier;

import fr.herman.gestionsalle.dao.OccuperDao;
import fr.herman.gestionsalle.dao.ProfDao;
import fr.herman.gestionsalle.entities.Occuper;
import fr.herman.gestionsalle.entities.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OccuperMetierImpl implements IOccuperMetier{
    @Autowired
    OccuperDao occuperDao;

    @Override
    public Occuper saveOccuper(Occuper occuper) {
        return occuperDao.save(occuper);
    }

    @Override
    public Occuper updateOccuper(Occuper occuper) {
        return occuperDao.save(occuper);
    }

    @Override
    public Occuper getOccuper(Integer id) {
        return occuperDao.getById(id);
    }

    @Override
    public List<Occuper> getAllOccuper() {
        return occuperDao.findAll();
    }

    @Override
    public List<Occuper> searchOccuper(String motcle) {
        return null;
    }

    @Override
    public boolean deleteOccuper(Occuper occuper) {
        try{
            occuperDao.delete(occuper);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
