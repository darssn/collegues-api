package dev.collegues.entite;

import javax.validation.constraints.NotNull;

public class CollegueRecup {

	@NotNull
	private String email;
	@NotNull
	private String photoUrl;

	/**
	 * @param email
	 * @param photoUrl
	 */
	public CollegueRecup(String email, String photoUrl) {
		super();
		this.email = email;
		this.photoUrl = photoUrl;
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
