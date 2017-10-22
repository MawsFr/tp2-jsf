package univ.lille1.miage.m2.listener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import univ.lille1.miage.m2.bean.Catalogue;
import univ.lille1.miage.m2.bean.ListingEmprunteur;
import univ.lille1.miage.m2.bean.Livre;
import univ.lille1.miage.m2.bean.Personne;
import univ.lille1.miage.m2.service.MetierCatalogue;
import univ.lille1.miage.m2.service.MetierPersonnes;

@WebListener
public class StartupServletListener implements ServletContextListener {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		ServletContext cntxt = sce.getServletContext();
		// Initialisation du listing des emprunteurs
		ListingEmprunteur personnesInstance = new ListingEmprunteur();

		Personne personne1 = new Personne();
		personne1.setLogin("test");
		personne1.setPassword("test");
		personne1.setNom("Test");
		personne1.setPrenom("Test");

		Personne personne2 = new Personne();
		personne2.setLogin("root");
		personne2.setPassword("root");
		personne2.setNom("Root");
		personne2.setPrenom("Root");

		Map<String, Personne> listePersonne = new HashMap<String, Personne>();
		listePersonne.put(personne1.getLogin() + personne1.getPassword(),
				personne1);
		listePersonne.put(personne2.getLogin() + personne2.getPassword(),
				personne2);

		personnesInstance.setListePersonne(listePersonne);
		
		cntxt.setAttribute(MetierPersonnes.CTX_ATTRIBUT_LISTING, personnesInstance);
		
		// Initialisation du catalogue
		Catalogue catalogue = new Catalogue();
		
		Livre livre1 = new Livre();
		livre1.setId("1");
		livre1.setTitre("L�gendes de Troy, T1");
		livre1.setAuteur("Keramidas, Arleston, Melanyn");
		livre1.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/3f/9b/25/2464575/1539-6.jpg ");
		livre1.setResume("Une nouvelle s�rie permettant � de grands dessinateurs d'explorer le vaste univers de Troy... Nicolas Keramidas ouvre le bal.");
		
		Livre livre2 = new Livre();
		livre2.setId("2");
		livre2.setTitre("Le kama-sutra magique");
		livre2.setAuteur("Stella Damiana");
		livre2.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/bb/e0/25/2482363/1539-6.jpg");
		livre2.setResume("Gr�ce au kama-sutra magique... passez une Saint Valentin piment�e ! (Bon, nous avons aussi d'autres rem�des en magasin...)");
		
		Livre livre3 = new Livre();
		livre3.setId("3");
		livre3.setTitre("La Conspiration du Temple");
		livre3.setAuteur("Steve Berry");
		livre3.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/42/2e/30/3157570/1539-1.jpg");
		livre3.setResume("Steve Berry au meilleur de sa forme pour son grand retour. Quand trembler fait du bien...");
		
		Livre livre4 = new Livre();
		livre4.setId("4");
		livre4.setTitre("Comment am�liorer son destin");
		livre4.setAuteur("Lise Bartoli");
		livre4.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/b0/21/2f/3088816/1539-6.jpg");
		livre4.setResume("Le destin existe, mais il n'est pas responsable de tout. On peut l'am�liorer. Voici comment...");
		
		Livre livre5 = new Livre();
		livre5.setId("5");
		livre5.setTitre("Un mensonge sur mon p�re");
		livre5.setAuteur("John Burnside");
		livre5.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/dd/98/2a/2791645/1539-6.jpg");
		livre5.setResume("Un grand livre sur le mensonge paternel, par John Burnside, l'�blouissant romancier �cossais.");
	

		Livre livre6 = new Livre();
		livre6.setId("6");
		livre6.setTitre("Le petit Spirou, T14");
		livre6.setAuteur("Janry, Tome");
		livre6.setImage("http://static.fnac-static.com/multimedia/Images/FR/NR/51/08/26/2492497/1539-6.jpg");
		
		List<Livre> listeLivre = new ArrayList<Livre>();
		listeLivre.add(livre1);
		listeLivre.add(livre2);
		listeLivre.add(livre3);
		listeLivre.add(livre4);
		listeLivre.add(livre5);
		listeLivre.add(livre6);
		
		catalogue.setListeLivre(listeLivre);

		
		cntxt.setAttribute(MetierCatalogue.CTX_ATTRIBUT_CATALOGUE, catalogue);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("Contexte Servlet D�truit!!");
	}

}
