package fr.herman.gestionsalle;

import fr.herman.gestionsalle.entities.Prof;
import fr.herman.gestionsalle.metier.IProfMetier;
import fr.herman.gestionsalle.metier.ProfMetierImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class GestionsalleApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionsalleApplication.class, args);
	}
/*	 @Bean
	CommandLineRunner start(ProfMetierImpl profMetier){
		return args -> {
			Prof prof =new Prof("PF_1","NIMA","Hery","Directeur");
			Prof p = profMetier.saveProf(prof);
			System.out.println(p.toString());
		};
	};*/
}
