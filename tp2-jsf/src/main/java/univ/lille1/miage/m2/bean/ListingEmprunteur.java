package univ.lille1.miage.m2.bean;

import java.util.Map;

public class ListingEmprunteur {

	private Map<String, Personne> listePersonne;

	public Map<String, Personne> getListePersonne() {
		return listePersonne;
	}

	public void setListePersonne(Map<String, Personne> listePersone) {
		this.listePersonne = listePersone;
	}

}
