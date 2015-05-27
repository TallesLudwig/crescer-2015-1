package filmator.controller;

import java.util.ArrayList;
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

@Controller
public class RegistrosController {

	public Biblioteca bibli = new Biblioteca();
	
	@Inject 
	private FilmeDao filmeDao;
	

	@RequestMapping(value = "/filmesSalvos", method = RequestMethod.GET)
	public String mostraCadastrados(Model model,  HttpSession session) {
		
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));

	
		model.addAttribute("listafilmes", filmeDao.buscaTodosFilmesJava8());	
	
			
		
		return "registroDeFilmes";
	
	}


}
