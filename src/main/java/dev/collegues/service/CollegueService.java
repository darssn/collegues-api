package dev.collegues.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.entite.CollegueRecup;
import dev.collegues.entite.PhotoWebApi;
import dev.collegues.exception.CollegueNonTrouveException;
import dev.collegues.repository.CollegueRepository;

@Service
public class CollegueService {

	private CollegueRepository collegueRepository;

	public CollegueService(CollegueRepository collegueRepository) {
		this.collegueRepository = collegueRepository;
	}

	public List<Collegue> liste() {
		return this.collegueRepository.findAll();
	}
	

	public List<Collegue> rechercheByNom(String nom) {

		return this.collegueRepository.findByNom(nom);

	}
	
	public List<PhotoWebApi> listePhoto(){
		return this.collegueRepository.listePhoto();
	}

	public Collegue rechercheByMatricule(String matricule) throws CollegueNonTrouveException {

		Optional<Collegue> col = this.collegueRepository.findByMatricule(matricule);
	
			return col.orElseThrow(()->new CollegueNonTrouveException("Collegue non trouvé"));
			
	}

	public ResponseEntity<String> creerCollegue(Collegue collegue) {

		if (collegueRepository.existsByNomAndPrenomsAndMatricule(collegue.getNom(), collegue.getPrenoms(),collegue.getMatricule())) {
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Collegue possedant deja le meme nom prenoms matricule");
			
		} else {
			
			collegueRepository.save(new Collegue(collegue.getNom(), collegue.getPrenoms(),collegue.getEmail(), collegue.getDateDeNaissance(), collegue.getPhotoUrl()));
			
			return ResponseEntity.status(HttpStatus.CREATED).body("Collegue enregistré");
		}

	}

	public ResponseEntity<String> modifCollegue(CollegueRecup collegue,String matricule){
		
		Optional <Collegue> col = collegueRepository.findByMatricule(matricule);
		
		if(!col.isPresent()){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Probleme matricule");
		}
		
		Collegue c = col.get();
		c.setPhotoUrl(collegue.getPhotoUrl());
		c.setEmail(collegue.getEmail());
		
		this.collegueRepository.save(c);
		
	
		return ResponseEntity.status(HttpStatus.OK).body("Collegue modifié");
	}
	
	
	


}
