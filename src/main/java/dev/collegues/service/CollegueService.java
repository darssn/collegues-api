package dev.collegues.service;

import java.util.List;

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
		
		return collegueRepository.findByNom(nom);
		
	}
}
