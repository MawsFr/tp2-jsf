package univ.lille1.miage.m2.bean;

import java.time.LocalDate;

public class Livre {

	private String id;
	private String titre;
	private String auteur;
	private String resume;
	private String image;
	private LocalDate dateSortie;
	private LocalDate dateRetour;
	private String emprunteur;
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public LocalDate getDateSortie() {
		return dateSortie;
	}
	public void setDateSortie(LocalDate dateSortie) {
		this.dateSortie = dateSortie;
	}
	public LocalDate getDateRetour() {
		return dateRetour;
	}
	public void setDateRetour(LocalDate dateRetour) {
		this.dateRetour = dateRetour;
	}
	public String getEmprunteur() {
		return emprunteur;
	}
	public void setEmprunteur(String emprunteur) {
		this.emprunteur = emprunteur;
	}
	
	
}
