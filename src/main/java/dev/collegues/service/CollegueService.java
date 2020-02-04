package dev.collegues.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dev.collegues.entite.Collegue;
import dev.collegues.repository.CollegueRepository;


@Service
public class CollegueService {
	
	private CollegueRepository collegueRepository;
	
	public CollegueService(CollegueRepository collegueRepository){
		this.collegueRepository = collegueRepository;
	}
	
	public List<Collegue>liste(){
		return this.collegueRepository.findAll();
	}

	
	public List<Collegue>rechercheByNom(String nom){
		
		return this.collegueRepository.findByNom(nom);
		
	}
	
	public Collegue rechercheByMatricule(String matricule){
		return this.collegueRepository.findByMatricule(matricule);
	}
	
	public ResponseEntity<String> creerCollegue(Collegue collegue){

			collegueRepository.save(new Collegue(collegue.getMatricule(),collegue.getNom(),collegue.getPrenoms(),collegue.getEmail(),collegue.getDateDeNaissance(),collegue.getPhotoUrl()));
			return ResponseEntity.status(HttpStatus.CREATED).body("Collegue enregistré");

		
	}
	
	public ResponseEntity<String> modifCollegue(Collegue collegue,String matricule){
		this.collegueRepository.save(collegue,matricule);
		return ResponseEntity.status(HttpStatus.OK).body("Collegue modifié");
	}
	
	
}
