package siw.progetto.galleriaArte.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import siw.progetto.galleriaArte.model.Autore;
import siw.progetto.galleriaArte.model.Opera;
import siw.progetto.galleriaArte.service.AutoreService;


@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreservice;
    
	 /* visione autori*/
	
	@GetMapping("/autori")
	public String showAutori(Model model) {
		List<Autore> autori = (List<Autore>) autoreservice.findAll();
		model.addAttribute(autori);
		return "autori";
	}
	

	@GetMapping("/autori/{id}")
	public String showAutore(Model model, @PathVariable("id") long autoreId) {
		Autore autore = autoreservice.findbyId(autoreId);
		model.addAttribute(autore);
		return "autore";
	}

	
	/* form */
	
	@GetMapping("/addautore")
    public String showForm(Autore autore) {
        return "formAutore";
    }

    @PostMapping("/addautore")
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
