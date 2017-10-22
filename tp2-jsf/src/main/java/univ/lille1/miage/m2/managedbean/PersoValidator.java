package univ.lille1.miage.m2.managedbean;

import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.service.MetierPersonnes;

@FacesValidator("loginValidator")
public class PersoValidator implements Validator {
	public void validate(FacesContext fc, UIComponent comp, Object ref)
			throws ValidatorException {
		String myValue = null;
		if (fc == null || comp == null || ref == null) {
			throw new NullPointerException();
		}
		myValue = ref.toString();
		if (!isLoginValid(myValue)) {
			throw new ValidatorException(new FacesMessage(
					FacesMessage.SEVERITY_ERROR,
					"Login existant", "Le login existe déjà"));
		}
	}
	
	public boolean isLoginValid(String login) {
		for (Map.Entry<String, Personne> entry : MetierPersonnes.getPersonnes().getListePersonne().entrySet()) {
			if(entry.getValue().getLogin().equalsIgnoreCase(login)) {
				return false;
			}
		}
		
		return true;
	}

}