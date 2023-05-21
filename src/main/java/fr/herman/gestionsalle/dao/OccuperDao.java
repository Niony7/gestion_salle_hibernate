package fr.herman.gestionsalle.dao;

import fr.herman.gestionsalle.entities.Occuper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OccuperDao extends JpaRepository<Occuper,Integer> {
}
