package dev.collegues.repository;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import dev.collegues.entite.*;

public interface CollegueRepository extends JpaRepository<Collegue,Integer>{

	
	List<Collegue> findByNom(String nom);
	
	Optional <Collegue> findByMatricule(String matricule);
	

	boolean existsByNomAndPrenomsAndMatricule(String nom,String prenoms,String matricule);
	

	@Query("SELECT c.matricule,c.photoUrl FROM Collegue c ")
	
	List<PhotoWebApi> listePhoto(); 
	

}
