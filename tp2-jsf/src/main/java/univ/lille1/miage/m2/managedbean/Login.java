package univ.lille1.miage.m2.managedbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.service.MetierPersonnes;

/**
 * @author nezzari
 *
 */
@ManagedBean(name="loginbean")
@SessionScoped
public class Login {
	
	private String login;
	private String password;
	private Personne personne;
	
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
	
	public Personne getPersonne() {
		return personne;
	}
	public void setPersonne(Personne personne) {
		this.personne = personne;
	}
	public String validate() {
		Personne personne = MetierPersonnes.getPersonne(login, password);
		if(personne == null) {
			return "error";	
		}
		
		this.personne = personne;
		
		return "success";
	}
	
}
