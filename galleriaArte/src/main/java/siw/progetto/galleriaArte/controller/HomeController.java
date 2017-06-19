package siw.progetto.galleriaArte.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller 
public class HomeController {
	
	@RequestMapping("/login")
	  public String login() {
	    return "login";
	  }
	
	@RequestMapping("/login-error.html")
	  public String loginError(Model model) {
	    model.addAttribute("loginError", true);
	    return "login";
	  }
	
	@RequestMapping("/home")
	public String mostraHome() {
		return "home";
	}
	
}
