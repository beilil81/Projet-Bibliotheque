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
	public String createEditeur(Model model) {
		
		System.out.println("create Editeur Success ");
		return "editeurs";
	}
	
	@RequestMapping("/deleteEditeur")
	public String supprimeEditeur(Model model, @RequestParam("id") Integer id) {
		
		try {
			editeurMetier.delete(id);
		} catch (Exception e) {
			
		}
		
		return index(model);
	}
	
	@RequestMapping("/editEditeur")
	public String updateEditeur(ModelAndView model) {
		
		Editeur editeur = (Editeur)model.getModel().get("editeur");
		System.out.println("Editeur : "+editeur + "   NOM : "+editeur.getNom());
		
		return index((Model)model);
	}

	/*Affiche la page formEditeur.html pour Modifier un Editeur*/
	@RequestMapping("/editFormEditeur")
	public String displayEditFormEditeur(Model model, @RequestParam("id")Integer id) {
		
		Editeur editeur = editeurMetier.find(id);
		model.addAttribute("editeur", editeur);
		
		return "/formEditeurs";
	}
	
	/*Affiche la page formEditeur.html pour Ajouter un Editeur*/
	@RequestMapping("/addFormEditeur")
	public String displayAddFormEditeur(Model model) {
		
		Editeur editeur = new Editeur();
		model.addAttribute("editeur", editeur);
		
		return "/formEditeurs";
	}


}
