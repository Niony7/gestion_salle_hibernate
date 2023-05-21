package fr.herman.gestionsalle.dao;

import fr.herman.gestionsalle.entities.Salle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalleDao extends JpaRepository<Salle,String> {
}
