package siw.progetto.galleriaArte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import siw.progetto.galleriaArte.model.Autore;
import siw.progetto.galleriaArte.model.Utente;
import siw.progetto.galleriaArte.service.UtenteService;



@Controller
public class UtenteController {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private UtenteService utenteservice; 

    	
    @GetMapping("/registrazione")
    public String showForm(Utente utente) {
        return "formUtente";
    }
    
	@PostMapping("/registrazione")
	public String registraUtente(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model){		
		
		if (bindingResult.hasErrors())
		{
			return "formUtente";
		}
		else {
			
			utente.setPassword(bCryptPasswordEncoder.encode(utente.getPassword()));
			utente.setEnabled(true);
			utente.setRuolo("ROLE_USER");
        	model.addAttribute(utente);
            utenteservice.add(utente); 
			
			return  "login";
			} 
		
	}
	
	
    @GetMapping("/admin/authAdmin")
    public String showAuth() {
        return "authAdmin";
    }
    
	@PostMapping("/admin/authAdmin")
	public String AutorizzaUtente(Model model, @ModelAttribute String username){		
		Utente utente = utenteservice.findByUsername(username);
		utente.setRuolo("ROLE_ADMIN"); 
		return  "home";
			} 
		
	
}
