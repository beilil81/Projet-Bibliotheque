package fitec.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fitec.com.entities.Auteur;
import fitec.com.service.IAuteurMetier;

@Controller
public class AuteurController {
	
	@Autowired
	private IAuteurMetier auteurMetier;
	
	@RequestMapping("/auteurs")
	public String index(Model model) {
		
		List<Auteur> list = auteurMetier.findAll();
		model.addAttribute("listAllAuteurs", list);
		
		return "auteurs";
	}
	
	@RequestMapping("/addAuteur")
	public String createAuteur(Model model, String nomAuteur, String prenomAuteur) {
		
		System.out.println("create Auteur Success :  " + nomAuteur);
		Auteur auteur = new Auteur();
		auteur.setNom(nomAuteur);
		auteur.setPrenom(prenomAuteur);
		auteurMetier.add(auteur);
		return "redirect:/auteurs";
	}
	
	@RequestMapping("/deleteAuteur")
	public String supprimeAuteur(Model model, @RequestParam("id") Integer id) {
		
		try {
			auteurMetier.delete(id);
		} catch (Exception e) {
			
		}
		
		return "redirect:/auteurs";
	}
	
	@RequestMapping("/editAuteur")
	public String updateAuteur(ModelAndView model,Integer idAuteur, String nomAuteur, String prenomAuteur) {
		
		Auteur auteur = auteurMetier.find(idAuteur);
		auteur.setNom(nomAuteur);
		auteur.setPrenom(prenomAuteur);
		System.out.println("Auteur id : "+idAuteur + "   NOM : "+nomAuteur + "  Prénom : " + prenomAuteur);
		auteur = auteurMetier.update(auteur);
		
		return "redirect:/auteurs";
	}

	/*Affiche la page formAuteur.html pour Modifier un Auteur*/
	@RequestMapping("/editFormAuteur")
	public String displayEditFormAuteur(Model model, @RequestParam("id")Integer id) {
		
		model.addAttribute("edit", 1);//pour avoir le formulaire d'edition
		Auteur auteur = auteurMetier.find(id);
		model.addAttribute("auteur", auteur);
		
		return "/formAuteur";
	}
	
	/*Affiche la page formAuteur.html pour Ajouter un Auteur*/
	@RequestMapping("/addFormAuteur")
	public String displayAddFormAuteur(Model model) {
		
		model.addAttribute("edit", 0);//pour avoir le formulaire d'ajout
		
		return "/formAuteur";
	}

	
	/*Affiche la page formAuteur.html pour Ajouter un Auteur*/
	@RequestMapping("/testAuteur")
	public String testAuteur(Model model,String coco) {
		
		System.out.println("TEST coco : " + coco);
		
		return "redirect:/auteurs";
	}

}
