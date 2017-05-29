package fitec.com;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import fitec.com.dao.AuteurRepository;
import fitec.com.dao.EditeurRepository;
import fitec.com.dao.LivreRepository;
import fitec.com.entities.Auteur;
import fitec.com.entities.Editeur;
import fitec.com.entities.Livre;
import fitec.com.service.IEditeurMetier;

@SpringBootApplication
public class BiblioStsApplication implements CommandLineRunner {
	
	@Autowired
	private EditeurRepository daoEditeur;
	@Autowired
	private AuteurRepository daoAuteur;
	@Autowired
	private LivreRepository daoLivre;
	@Autowired
	private IEditeurMetier editeurMetier;
	

	public static void main(String[] args) {
		
		SpringApplication.run(BiblioStsApplication.class, args);
		
//		ApplicationContext ctx =  SpringApplication.run(BiblioStsApplication.class, args);
//		EditeurRepository daoEditeur = ctx.getBean(EditeurRepository.class);
//		AuteurRepository daoAuteur = ctx.getBean(AuteurRepository.class);
//		LivreRepository daoLivre = ctx.getBean(LivreRepository.class);
		
	}


	@Override
	public void run(String... arg0) throws Exception {


//		EditeurRepository daoEditeur = ctx.getBean(EditeurRepository.class);
//		AuteurRepository daoAuteur = ctx.getBean(AuteurRepository.class);
//		LivreRepository daoLivre = ctx.getBean(LivreRepository.class);
		
		/*LISTE DES EDITEURS*/
		List<Editeur> editeurs = daoEditeur.findAll();
		System.out.println("\n*********** TOUS LES EDITEURS ***********");
		for(Editeur e : editeurs) {
			System.out.println(e.toString());
		}
		
		/*LISTE DES AUTEURS*/
		List<Auteur> auteurs = daoAuteur.findAll();
		System.out.println("\n*********** TOUS LES AUTEURS ***********");
		for(Auteur a : auteurs) {
			System.out.println(a.toString());
		}
		
		/*LISTE DES LIVRES*/
		List<Livre> livres = daoLivre.findAll();
		System.out.println("\n*********** TOUS LES LIVRES ***********");
		for(Livre l : livres) {
			System.out.println(l.toString());
		}   
		
		/*LISTE DES LIVRES POUR LE MEME EDITEUR*/
		Editeur e1 = daoEditeur.findOne(1);
		List<Livre> listEdLivres = daoEditeur.getAllLivresByEditeurId(e1.getId());
		System.out.println("\n*********** TOUS LES LIVRES DE L'EDITEUR ID = "+ e1.getId() +"***********");
		for(Livre l : listEdLivres) {
			System.out.println(l.toString());
		}
		
		/*LISTE DES LIVRES POUR LE MEME AUTEUR*/
		Auteur a1 = daoAuteur.findOne(1);
		List<Livre> listALivres = daoAuteur.getAllLivresByAuteurId(a1.getId());
		System.out.println("\n*********** TOUS LES LIVRES DE L'AUTEUR ID = "+ a1.getId() +"***********");
		for(Livre l : listALivres) {
			System.out.println(l.toString());
		}
		
		/*TEST DELETE EDITEUR REFERENCE DANS UN LIVRE*/
//		try{
//			editeurMetier.delete(1);
//		} catch (Exception e) {
//			System.out.println(e.getLocalizedMessage());
//		}
		
		
		
	}
}
