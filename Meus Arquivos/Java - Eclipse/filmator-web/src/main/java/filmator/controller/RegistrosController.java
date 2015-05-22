package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.model.Biblioteca;
import filmator.model.Filme;
import filmator.model.Genero;


@Controller
public class RegistrosController {
	
	@RequestMapping(value = "/filmesSalvos", method=RequestMethod.GET)
	public String abreTelaCadastro(Biblioteca c, Model mode) {
		model.addAttribute("nome", c. ));
		model.addAttribute("ano", ));		
		return "cadastro";
	}


}
