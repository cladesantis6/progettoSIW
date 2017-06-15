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

import siw.progetto.galleriaArte.model.Opera;
import siw.progetto.galleriaArte.service.AutoreService;
import siw.progetto.galleriaArte.service.OperaService;



@Controller
public class OperaController {

	@Autowired
	private OperaService operaservice; 
	private AutoreService autoreservice; 


	 /* visione delle opere*/
	
	
	@GetMapping("/opere")
	public String showOpere(Model model) {
		List<Opera> opere = (List<Opera>) operaservice.findAll();
		model.addAttribute(opere);
		return "opere";
	}

	@GetMapping("/opere/{id}")
	public String showOpera(Model model, @PathVariable("id") long operaId) {
		Opera opera = operaservice.findbyId(operaId);
		model.addAttribute(opera);
		return "opera";
	}

	
	@GetMapping("/addOpera")
	public String showForm(Model model, Opera opera){
		model.addAttribute("autori", autoreservice.findAll());
		return "formOpera";
	}
	
	/* form */
	
	
	@PostMapping("/addOpera")
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

/*@PostMapping(value="/opere{id}", params="delete")                                     //rivedi
		public String cancellaOpera(Model model, @PathVariable("id") long operaId) {
			Opera opera = operaservice.findbyId(operaId);
			this.operaservice.delete(opera);
			model.addAttribute(this.operaservice.findAll());
			return "opere";
		}
		*/
	}

