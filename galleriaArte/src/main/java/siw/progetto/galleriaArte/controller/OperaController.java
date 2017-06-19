package siw.progetto.galleriaArte.controller;



import java.util.List;

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
import siw.progetto.galleriaArte.model.Opera;
import siw.progetto.galleriaArte.service.AutoreService;
import siw.progetto.galleriaArte.service.OperaService;



@Controller
public class OperaController {

	@Autowired
	private OperaService operaservice; 
	@Autowired
	private AutoreService autoreservice; 


	 /* visione delle opere*/
	
	
	@GetMapping("/home/opere/titolo")
	public String showOpere(Model model) {
		model.addAttribute("opere", operaservice.findAll());
		return "opere";
	}
	
	@GetMapping("/home/opere/anno")
	public String showOpereAnno(Model model) {
		model.addAttribute("opere", operaservice.findAllByAnno());
		return "opere";
	}


	@GetMapping("/home/opere/opera")
	public String showOpera(Model model, @RequestParam("id") long idOpera) {
		Opera opera= operaservice.findbyId(idOpera);
		model.addAttribute(opera);
		return "opera";
	}
	
	@GetMapping("/home/opere/autore")
	public String showOpereAutore(Model model, @RequestParam("id") long idAutore) {
		Autore autore = autoreservice.findbyId(idAutore);
		List<Opera> opere = (List<Opera>) operaservice.findByAutore(autore);
		model.addAttribute("opere", opere);
		return "opereAutore";
	}


	
	@GetMapping("/admin/addOpera")
	public String showForm(Opera opera, Model model){
		model.addAttribute("autori", autoreservice.findAll());
		return "formOpera";
	}
	
	/* form */
	
	
	@PostMapping("/admin/addOpera")
	public String checkOpera(@Valid @ModelAttribute Opera opera,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()){
			return "formOpera";
		}
		else {
			model.addAttribute(opera);
			operaservice.add(opera);
		}
		return "opera";
	}

	@PostMapping(value="/home/opere/opera", params="delete")
	public String deleteOpera (Model model, @RequestParam("id") long idOpera) {
		Opera opera = operaservice.findbyId(idOpera);
		this.operaservice.delete(opera);
		model.addAttribute("opere",this.operaservice.findAll());
		return "opere";
	}

	
}
