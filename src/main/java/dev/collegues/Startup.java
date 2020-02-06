package dev.collegues;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.collegues.entite.Collegue;
import dev.collegues.repository.CollegueRepository;


@Component
public class Startup {

	private static final Logger LOG = LoggerFactory.getLogger(Startup.class);

	private CollegueRepository collegueRepository;


	public Startup(CollegueRepository collegueRepository) {
		super();
		this.collegueRepository = collegueRepository;
	}

	@EventListener(ContextRefreshedEvent.class)

	public void init() {

		LOG.info("Démarrage de l'application");

		if (this.collegueRepository.count() == 0) {

			List<Collegue> listeCol = new ArrayList<Collegue>();
			
			listeCol.add(new Collegue("Pierre", "Jean","PJ@XXX.com",LocalDate.parse("2019-10-10"),"photo.png"));
			listeCol.add(new Collegue("Pierre", "Dimitri","PD@XXX.com",LocalDate.parse("2019-10-10"),"photo.png"));
			listeCol.add(new Collegue("Albert", "Dimitri","AD@XXX.com",LocalDate.parse("2019-10-10"),"photo.png"));
			listeCol.add(new Collegue("Durand", "Martin","DM@XXX.com",LocalDate.parse("2019-10-10"),"photo.png"));

			this.collegueRepository.saveAll(listeCol);
		}
	}
	
}