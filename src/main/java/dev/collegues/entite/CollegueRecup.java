package dev.collegues.entite;

public class CollegueRecup {

	private String email;
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
