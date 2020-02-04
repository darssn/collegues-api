package dev.collegues.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import dev.collegues.service.CollegueService;


@RestController
@RequestMapping("collegues")
public class CollegueCtrl {
	
	private static final Logger LOG = LoggerFactory.getLogger(CollegueCtrl.class);
	
	private CollegueService collegueService;

	public CollegueCtrl(CollegueService collegueService){
		this.collegueService = collegueService;
	}
	
	@GetMapping(params = "nom")
	public List<String>rechercheNom(@RequestParam("nom") @Valid String nom){
		
		return collegueService.rechercheByNom(nom);	
	}
	
}
