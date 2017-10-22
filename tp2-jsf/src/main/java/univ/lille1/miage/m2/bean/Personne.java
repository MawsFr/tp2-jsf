package univ.lille1.miage.m2.bean;

import java.util.Date;

public class Personne {
	private String nom;
	private String prenom;
	private String login;
	private String password;
	private boolean droitImage;
	private Date dateDeNaissance;
	private int civilite;
	private long age;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;	

	}

	public boolean getDroitImage() {
		return droitImage;
	}

	public void setDroitImage(boolean droitImage) {
		this.droitImage = droitImage;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getCivilite() {
		return civilite;
	}

	public void setCivilite(int civilite) {
		this.civilite = civilite;
	}

	public long getAge() {
		return age;
	}

	public void setAge(long age) {
		this.age = age;
	}
	
	
	
	
}
