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
        return "registrazione";
    }
    
	@PostMapping("/registrazione")
	public String registraUtente(@Valid @ModelAttribute Utente utente, BindingResult bindingResult, Model model){		
		
		if (bindingResult.hasErrors())
		{
			return "registrazione";
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
	
	// per dare ad un altro utente i permessi di admin
    @GetMapping("/admin/authAdmin")
    public String showAuth(Utente utente) {
        return "authAdmin";
    }
    
	@PostMapping("/admin/authAdmin")
	public String AutorizzaUtente(Model model, @ModelAttribute Utente utente){		
		
		if (utenteservice.findByUsername(utente.getUsername()) != null) {
			Utente utente2A = utenteservice.findByUsername(utente.getUsername());
			utente2A.setRuolo("ROLE_ADMIN");
			utenteservice.add(utente2A);
			return  "home";
		}
		else return "authAdmin";
			} 
		
	
}
