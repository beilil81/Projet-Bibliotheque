package fitec.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fitec.com.entities.Auteur;
import fitec.com.entities.Editeur;
import fitec.com.entities.Livre;
import fitec.com.service.IAuteurMetier;
import fitec.com.service.IEditeurMetier;
import fitec.com.service.ILivreMetier;

@Controller
public class LivreController {
	
	@Autowired
	private ILivreMetier livreMetier;
	@Autowired
	private IAuteurMetier auteurMetier;
	@Autowired
	private IEditeurMetier editeurMetier;
	
	@RequestMapping("/livres")
	public String index(Model model) {
		
		List<Livre> list = livreMetier.findAll();
		model.addAttribute("listAllLivres", list);
		
		return "livres";
	}
	
	@RequestMapping("/addLivre")
	public String createLivre(Model model, String titreLivre, float prixLivre, Integer nb_pages ) {
		
		Editeur editeur = editeurMetier.findAll().get(0);
		Auteur auteur = auteurMetier.findAll().get(0);
		
		System.out.println("create Livre Success :  " + titreLivre);
		Livre livre = new Livre();
		livre.setTitre(titreLivre);
		livre.setPrix(prixLivre);
		livre.setNb_pages(nb_pages);
		
		livre.setEditeur(editeur);
		livre.setAuteur(auteur);
		
		livreMetier.add(livre);
		return "redirect:/livres";
	}
	
	@RequestMapping("/deleteLivre")
	public String supprimeLivre(Model model, @RequestParam("id") Integer id) {
		
		try {
			livreMetier.delete(id);
		} catch (Exception e) {
			
		}
		
		return "redirect:/livres";
	}
	
	@RequestMapping("/editLivre")
	public String updateLivre(ModelAndView model,Integer idLivre, String titreLivre, float prixLivre, Integer nb_pages) {
		
		Livre livre = livreMetier.find(idLivre);
		livre.setTitre(titreLivre);
		livre.setPrix(prixLivre);
		livre.setNb_pages(nb_pages);
		System.out.println("Livre id : "+idLivre + "   TITRE : "+titreLivre + "  Prix : " + prixLivre + "  NB PAGE : " + nb_pages);
		livre = livreMetier.update(livre);
		
		return "redirect:/livres";
	}

	/*Affiche la page formLivre.html pour Modifier un Livre*/
	@RequestMapping("/editFormLivre")
	public String displayEditFormLivre(Model model, @RequestParam("id")Integer id) {
		
		model.addAttribute("edit", 1);//pour avoir le formulaire d'edition
		Livre livre = livreMetier.find(id);
		model.addAttribute("livre", livre);
		
		return "/formLivre";
	}
	
	/*Affiche la page formLivre.html pour Ajouter un Livre*/
	@RequestMapping("/addFormLivre")
	public String displayAddFormLivre(Model model) {
		
		model.addAttribute("edit", 0);//pour avoir le formulaire d'ajout
		
		return "/formLivre";
	}

	
	/*Affiche la page formLivre.html pour Ajouter un Livre*/
	@RequestMapping("/testLivre")
	public String testLivre(Model model,String coco) {
		
		System.out.println("TEST coco : " + coco);
		
		return "redirect:/livres";
	}

}
