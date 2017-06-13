package siw.progetto.galleriaArte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import siw.progetto.galleriaArte.model.Autore;
import siw.progetto.galleriaArte.service.AutoreService;


@Controller
public class AutoreController {
	
	@Autowired
	private AutoreService autoreservice;
    
	@GetMapping("/autore")
    public String showForm(Autore autore) {
        return "formAutore";
    }

    @PostMapping("/autore")
    public String checkCustomerInfo(@Valid @ModelAttribute Autore autore, 
    									BindingResult bindingResult, Model model) {
    	
        if (bindingResult.hasErrors()) {
            return "formAutore";
        }
        else {
        	model.addAttribute(autore);
            autoreservice.add(autore); 
        }
        return "results";
    }
}
