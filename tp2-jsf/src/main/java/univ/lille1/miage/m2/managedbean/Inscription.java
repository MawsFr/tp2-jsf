package univ.lille1.miage.m2.managedbean;

import java.util.Calendar;
import java.util.Date;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.service.MetierPersonnes;

@ManagedBean(name = "inscription")
@SessionScoped
public class Inscription {

	private String nom;
	private String prenom;
	private String login;
	private String password;
	private boolean droitImage;
	private Date dateDeNaissance;
	private int civilite;

	public String getNom() {
		return nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(final String password) {
		this.password = password;
	}

	public boolean getDroitImage() {
		return droitImage;
	}

	public void setDroitImage(final boolean droitImage) {
		this.droitImage = droitImage;
	}

	public Date getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(final Date dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public int getCivilite() {
		return civilite;
	}

	public void setCivilite(final int civilite) {
		this.civilite = civilite;
	}

	public long getAge() {
		return getTimeDiff(new Date(), this.dateDeNaissance);
	}

	public long getTimeDiff(final Date dateOne, final Date dateTwo) {
		if(dateOne == null) {
			return 0;
		}
		if(dateTwo == null) {
			return 0;
		}
		final Calendar c1 = Calendar.getInstance();
		final Calendar c2 = Calendar.getInstance();
		
		c1.setTime(dateOne);
		c2.setTime(dateTwo);
		return c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
	}

	public String validate() {
		if (MetierPersonnes.getPersonne(login, password) == null) {
			MetierPersonnes.inscription(login, password, nom, prenom, droitImage, dateDeNaissance, civilite, getAge());
			return "success";
		}

		return "error";
	}

}
