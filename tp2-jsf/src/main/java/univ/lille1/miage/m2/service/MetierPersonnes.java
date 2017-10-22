package univ.lille1.miage.m2.service;

import java.util.Date;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import univ.lille1.miage.m2.bean.ListingEmprunteur;
import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.listener.StartupServletListener;

public class MetierPersonnes {


	public static final String CTX_ATTRIBUT_LISTING = "LISTING";

	/**
	 * R�cup�ration de la liste des emprunteur. 
	 * Cette liste est initialis�e au d�marrage de l'application
	 * @see StartupServletListener
	 * @return {@link ListingEmprunteur}
	 */
	public static ListingEmprunteur getPersonnes() {
		ServletContext context = 
				(ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext() ;
		return (ListingEmprunteur) context.getAttribute(CTX_ATTRIBUT_LISTING);
	}

	/**
	 * @param login
	 * @param password
	 * @return
	 */
	public static Personne getPersonne(String login, String password) {
		return getPersonnes().getListePersonne().get(login + password);

	}

	public static void inscription(String login, String password, String nom, String prenom, Boolean droitImage, Date dateDeNaissance, int civilite, long age) {
		Personne personne = new Personne();
		personne.setLogin(login);
		personne.setPassword(password);
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setDroitImage(droitImage);
		personne.setDateDeNaissance(dateDeNaissance);
		personne.setCivilite(civilite);
		personne.setAge(age);

		getPersonnes().getListePersonne().put(login+password, personne);
	}

}
