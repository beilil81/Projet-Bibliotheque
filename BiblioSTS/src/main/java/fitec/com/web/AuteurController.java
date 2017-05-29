package fitec.com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String createAuteur() {
		
		System.out.println("Add Auteur Success ");
		return "auteurs";
	}
	
	@RequestMapping("/deleteAuteur")
	public String supprimeAuteur(Model model, @RequestParam("id") Integer id) {
		
		try {
			auteurMetier.delete(id);
		} catch (Exception e) {}
		
		return index(model);
	}
	
	@RequestMapping("/editAuteur")
	public String updateAuteur(Model model, @RequestParam("id")Integer id) {
		
		List<Auteur> list = auteurMetier.findAll();
		model.addAttribute("listAllAuteurs", list);
		
		System.out.println("Edit Auteur Success : "+id);
		
		return "/auteurs";
	}
	


}
