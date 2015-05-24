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

	public Biblioteca bibli = new Biblioteca();
	
	@RequestMapping(value = "/filmesSalvos", method=RequestMethod.GET)
	public String mostraCadastrados( Model model) {
		
		for (Filme a : bibli.getLista()) {
		
			model.addAttribute("nome", a.getNome() );
			model.addAttribute("ano", a.getAno() );
			
			model.addAttribute("listaFilmes", bibli.getLista());
			
			model.addAttribute("sinopse", a.getSinopse() );
			model.addAttribute("imagem", a.getImagem() );
			
			
		}
	
	
		return "registroDeFilmes";
	}


}
