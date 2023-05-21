package fr.herman.gestionsalle.dao;

import fr.herman.gestionsalle.entities.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfDao extends JpaRepository<Prof,String> {
}
