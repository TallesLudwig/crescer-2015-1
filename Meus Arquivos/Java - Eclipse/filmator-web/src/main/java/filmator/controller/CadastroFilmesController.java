package filmator.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

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
public class CadastroFilmesController {
	
	
	@Inject 
	private FilmeDao filmeDao;

	@RequestMapping(value = "/cadastro-filmes", method=RequestMethod.GET)
	public String abreTelaCadastro(Model model, HttpSession session) {
		
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		boolean isAdmin = (boolean) session.getAttribute("usuarioAdmin");
		if(isAdmin){
			model.addAttribute("generos", Genero.values());
			return "cadastroFilmes";
		}
		else{
			return "redirect:/naoAutorizado";
		}
		
		
	}

	
	

	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Model model, Filme filme) {
	
		filmeDao.inserir(filme);

		
		return "redirect:/cadastro-filmes";
		
	}
	
	
}

