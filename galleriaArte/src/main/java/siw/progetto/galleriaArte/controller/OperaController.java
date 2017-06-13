package siw.progetto.galleriaArte.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import siw.progetto.galleriaArte.model.Opera;
import siw.progetto.galleriaArte.service.OperaService;



@Controller
public class OperaController {
	
    @Autowired
    private OperaService operaservice; 
    
	@GetMapping("/opera")
	public String showForm(Opera opera){
		return "formOpera";
	}
	
	@PostMapping("/opera")
	public String checkOpera(@Valid @ModelAttribute Opera opera,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			return "formOpera";
		}
		else {
			model.addAttribute(opera);
			operaservice.add(opera);
		}
		return "resultOpera";
	}
	
	
}
