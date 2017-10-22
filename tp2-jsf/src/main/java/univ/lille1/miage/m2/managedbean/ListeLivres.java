package univ.lille1.miage.m2.managedbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import univ.lille1.miage.m2.bean.Livre;
import univ.lille1.miage.m2.service.MetierCatalogue;

@ManagedBean(name="listeLivres")
@SessionScoped
public class ListeLivres {
	
	private Map <String, Boolean> checked;
	private String login;
	
	public ListeLivres() {
		this.checked = new HashMap<>();
	}
	
	 /**
     * @return the livres
     */
    public List<Livre> getLivres() {
            return MetierCatalogue.getLivreNonEmprunte();
    }

	public Map<String, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(final Map<String, Boolean> checked) {
		this.checked = checked;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(final String login) {
		this.login = login;
	}
    
	public String emprunterLivres() {
        final List<Livre> livres = MetierCatalogue.getCatalogue()
                        .getListeLivre();
        for (final Livre livre : livres) {
                if (checked.get(livre.getId()) != null && checked.get(livre.getId())) {
                        livre.setEmprunteur(login);
                }
        }
        return "success";
   }

}
