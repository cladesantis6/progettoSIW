package siw.progetto.galleriaArte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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
    private UtenteService utenteservice; 
    	
	
}
