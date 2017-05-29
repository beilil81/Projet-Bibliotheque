package fitec.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fitec.com.entities.Editeur;
import fitec.com.service.IEditeurMetier;

@Controller
public class EditeurController {
	
	@Autowired
	private IEditeurMetier editeurMetier;
	
	@RequestMapping("/editeurs")
	public String index(Model model) {
		
		List<Editeur> list = editeurMetier.findAll();
		model.addAttribute("listAllEditeurs", list);
		
		return "editeurs";
	}
	
	@RequestMapping("/addEditeur")
	public String createEditeur(Model model, String nomEditeur) {
		
		System.out.println("create Editeur Success :  " + nomEditeur);
		Editeur editeur = new Editeur();
		editeur.setNom(nomEditeur);
		editeurMetier.add(editeur);
		return "redirect:/editeurs";
	}
	
	@RequestMapping("/deleteEditeur")
	public String supprimeEditeur(Model model, @RequestParam("id") Integer id) {
		
		try {
			editeurMetier.delete(id);
		} catch (Exception e) {
			
		}
		
		return "redirect:/editeurs";
	}
	
	@RequestMapping("/editEditeur")
	public String updateEditeur(ModelAndView model,Integer idEditeur, String nomEditeur) {
		
		Editeur editeur = editeurMetier.find(idEditeur);
		editeur.setNom(nomEditeur);
		System.out.println("Editeur id : "+idEditeur + "   NOM : "+nomEditeur);
		editeur = editeurMetier.update(editeur);
		
		return "redirect:/editeurs";
	}

	/*Affiche la page formEditeur.html pour Modifier un Editeur*/
	@RequestMapping("/editFormEditeur")
	public String displayEditFormEditeur(Model model, @RequestParam("id")Integer id) {
		
		model.addAttribute("edit", 1);//pour avoir le formulaire d'edition
		Editeur editeur = editeurMetier.find(id);
		model.addAttribute("editeur", editeur);
		
		return "/formEditeur";
	}
	
	/*Affiche la page formEditeur.html pour Ajouter un Editeur*/
	@RequestMapping("/addFormEditeur")
	public String displayAddFormEditeur(Model model) {
		
		model.addAttribute("edit", 0);//pour avoir le formulaire d'ajout
		
		return "/formEditeur";
	}

	
	/*Affiche la page formEditeur.html pour Ajouter un Editeur*/
	@RequestMapping("/testEditeur")
	public String testEditeur(Model model,String coco) {
		
		System.out.println("TEST coco : " + coco);
		
		return "redirect:/editeurs";
	}

}
