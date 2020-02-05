package dev.collegues.controller;

import java.util.List;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dev.collegues.entite.Collegue;
import dev.collegues.entite.CollegueRecup;
import dev.collegues.exception.CollegueNonTrouveException;
import dev.collegues.service.CollegueService;


@CrossOrigin
@RestController
@RequestMapping("collegues")
public class CollegueCtrl {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollegueCtrl.class);
	
	private CollegueService collegueService;

	public CollegueCtrl(CollegueService collegueService){
		this.collegueService = collegueService;
	}
	
	
	@GetMapping
	public List<Collegue>listeCollegue(){
		return this.collegueService.liste();
	}
	
	
	@GetMapping(params = "nom")
	public List<Collegue>rechercheNom(@RequestParam("nom") @Valid String nom){
		LOG.info("Recherche nom collegue");
		return this.collegueService.rechercheByNom(nom);	
	}
	
	@GetMapping(path="/{matricule}")
	
	public Collegue rechercheMatricule(@PathVariable("matricule") @Valid String matricule) throws CollegueNonTrouveException{

		return this.collegueService.rechercheByMatricule(matricule);
		
		
	}
	
	@PostMapping()
	public ResponseEntity<String>createCollegue(@RequestBody @Valid Collegue collegue){

		return collegueService.creerCollegue(collegue);

	}
	
	@PatchMapping(path="/{matricule}")
	public ResponseEntity<String>modifCollegue(@RequestBody @Valid CollegueRecup collegue, @PathVariable("matricule") @Valid String matricule){
		
		return this.collegueService.modifCollegue(collegue,matricule);
		
	}
	
	
	
	@ExceptionHandler(CollegueNonTrouveException.class)
	public ResponseEntity<?> reponse(CollegueNonTrouveException e){
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		
	}
	
}

