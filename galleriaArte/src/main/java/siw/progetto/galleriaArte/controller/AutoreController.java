package siw.progetto.galleriaArte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siw.progetto.galleriaArte.model.Autore;
import siw.progetto.galleriaArte.service.AutoreService;


@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreservice;
    
	 /* visione autori*/
	
	@GetMapping("/home/autori")
	public String showAutori(Model model) {
		//List<Autore> autori = (List<Autore>) autoreservice.findAll();
		//for (Autore autore:autori ) {System.out.println(""+autore.getCognome());}
		model.addAttribute("autori", autoreservice.findAll());
		return "autori";
	}
	
	@GetMapping("/home/autori/autore")
	public String showAutore(Model model, @RequestParam("id") long idAutore) {
		Autore autore = autoreservice.findbyId(idAutore);
		model.addAttribute(autore);
		return "autore";
	}
	
	
	/*@GetMapping("/autori/autore/{idAutore}")//"/autori/autore/{autoreId}")
	public String showAutore(Model model, @PathVariable("idAutore") long idAutore) {
		Autore autore = autoreservice.findbyId(idAutore);
		model.addAttribute(autore);
		return "autore";
	}*/
	
	/* form */
	
	@GetMapping("/home/addAutore")
    public String showForm(Autore autore) {
        return "formAutore";
    }

    @PostMapping("/home/addAutore")
    public String checkCustomerInfo(@Valid @ModelAttribute Autore autore, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formAutore";
        }
        else {
        	model.addAttribute(autore);
            autoreservice.add(autore); 
        }
        return "autore";
    }
    
/*	@PostMapping(value="/autore{id}", params="delete")                                     //rivedi
	public String cancellaAutore(Model model, @PathVariable("id") long autoreId) {
		Autore autore = autoreservice.findbyId(autoreId);
		this.autoreservice.delete(autore);
		model.addAttribute(this.autoreservice.findAll());
		return "autori";
	}*/
}
