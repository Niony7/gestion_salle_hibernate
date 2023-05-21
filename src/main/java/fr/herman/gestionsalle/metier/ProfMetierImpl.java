package fr.herman.gestionsalle.metier;

import fr.herman.gestionsalle.dao.ProfDao;
import fr.herman.gestionsalle.entities.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ProfMetierImpl implements IProfMetier{
    @Autowired
    ProfDao profDao;

    @Override
    public Prof saveProf(Prof prof) {
        return profDao.save(prof);
    }

    @Override
    public Prof updateProf(Prof prof) {
        return profDao.save(prof);
    }

    @Override
    public Prof getProf(String codeprof) {
        return profDao.getById(codeprof);
    }

    @Override
    public List<Prof> getAllProf() {
        return profDao.findAll();
    }

    @Override
    public List<Prof> searchProf(String motcle) {
        return null;
    }

    @Override
    public boolean deleteProf(Prof prof) {
        try{
            profDao.delete(prof);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}
