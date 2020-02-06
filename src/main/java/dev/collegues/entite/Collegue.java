package dev.collegues.entite;

import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
public class Collegue {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	@NotNull
	private String matricule;
	@NotNull
	private String nom;
	@NotNull
	private String prenoms;
	@NotNull
	private String email;
	@NotNull
	private LocalDate dateDeNaissance;
	@NotNull
	private String photoUrl;
	
	public Collegue(){
		
	}
	
	public Collegue(String nom,String prenoms,String email,LocalDate date,String photo){
		
		this.matricule = UUID.randomUUID().toString();
		this.nom = nom;
		this.prenoms = prenoms;
		this.email=email;
		this.dateDeNaissance = date;
		this.photoUrl = photo;
	}

	/**Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**Getter
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**Setter
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	/**Getter
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**Setter
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**Getter
	 * @return the prenoms
	 */
	public String getPrenoms() {
		return prenoms;
	}

	/**Setter
	 * @param prenoms the prenoms to set
	 */
	public void setPrenoms(String prenoms) {
		this.prenoms = prenoms;
	}

	/**Getter
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**Setter
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**Getter
	 * @return the dateDeNaissance
	 */
	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	/**Setter
	 * @param dateDeNaissance the dateDeNaissance to set
	 */
	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	/**Getter
	 * @return the photoUrl
	 */
	public String getPhotoUrl() {
		return photoUrl;
	}

	/**Setter
	 * @param photoUrl the photoUrl to set
	 */
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	
	
}
