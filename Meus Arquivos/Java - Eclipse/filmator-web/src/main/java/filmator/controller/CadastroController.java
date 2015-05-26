package filmator.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Biblioteca;
import filmator.model.Filme;
import filmator.model.Genero;


@Controller
public class CadastroController {
	
	
	@Inject 
	private FilmeDao filmeDao;

	@RequestMapping(value = "/cadastro-filmes", method=RequestMethod.GET)
	public String abreTelaCadastro(Filme filme, Model model) {
		model.addAttribute("generos", Genero.values());
		return "cadastro";
	}

	
	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Model model, Filme filme) {
	
		filmeDao.inserir(filme);

		
		return "redirect:/cadastro-filmes";
		
		//return filmeDao.buscaTodosFilmesJava8();
	}
	
	
}

