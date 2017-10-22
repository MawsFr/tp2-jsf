package univ.lille1.miage.m2.managedbean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import univ.lille1.miage.m2.bean.Livre;
import univ.lille1.miage.m2.service.MetierCatalogue;

@ManagedBean(name="listeLivresEmpruntes")
@SessionScoped
public class LivresEmpruntes {
	
	private Map <String, Boolean> checked;
	
	public LivresEmpruntes() {
		this.checked = new HashMap<>();
	}
	
	public String getLoginValue() {
	    final FacesContext facesContext = FacesContext.getCurrentInstance();
	    final Login login = (Login) facesContext.getExternalContext().getSessionMap().get("loginbean");
	    return login.getLogin();
	}
	
	 /**
     * @return the livres
     */
    public List<Livre> getLivres() {
            return MetierCatalogue.getLivreEmprunte(getLoginValue());
    }

	public Map<String, Boolean> getChecked() {
		return checked;
	}

	public void setChecked(final Map<String, Boolean> checked) {
		this.checked = checked;
	}

	public String rendreLivres() {
        final List<Livre> livres = MetierCatalogue.getCatalogue()
                        .getListeLivre();
        for (final Livre livre : livres) {
                if (checked.get(livre.getId()) != null && checked.get(livre.getId())) {
                        livre.setEmprunteur(null);
                }
        }
        return "success";
   }

}
