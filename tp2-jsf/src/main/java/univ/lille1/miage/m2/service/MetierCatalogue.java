package univ.lille1.miage.m2.service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;

import univ.lille1.miage.m2.bean.Catalogue;
import univ.lille1.miage.m2.bean.ListingEmprunteur;
import univ.lille1.miage.m2.bean.Livre;

public class MetierCatalogue {

	public static final String CTX_ATTRIBUT_CATALOGUE = "CATALOGUE";
	
	public static Catalogue getCatalogue(){
		ServletContext context = 
			      (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext() ;
		return (Catalogue) context.getAttribute(CTX_ATTRIBUT_CATALOGUE);
	}
	
	public static List<Livre> getLivreEmprunte(String login){
		return getCatalogue().getListeLivre().stream()
			.filter(l -> l.getEmprunteur() != null && l.getEmprunteur().equals(login))
			.collect(Collectors.toList());
		
	}

	public static List<Livre> getLivreNonEmprunte(){
		return getCatalogue().getListeLivre().stream()
				.filter(l -> l.getEmprunteur() == null)
				.collect(Collectors.toList());
	}
	
	

}
