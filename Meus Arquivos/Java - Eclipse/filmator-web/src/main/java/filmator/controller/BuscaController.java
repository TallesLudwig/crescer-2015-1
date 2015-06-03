package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.model.Filme;

@Controller
public class BuscaController {
	List<Filme> filmes= new ArrayList<>();
	@Inject 
	private FilmeDao filmeDao;
	
	
	
	@RequestMapping(value = "/filmesBusca", method = RequestMethod.GET)
	public String mostraCadastrados(Model model,  HttpSession session) {
		
	
		Boolean isAdmin = (Boolean) session.getAttribute("usuarioAdmin");
		model.addAttribute("isAdmin", isAdmin != null && isAdmin);
		model.addAttribute("listafilmes", filmeDao.buscaTodosFilmesJava8());	
		model.addAttribute("removeFilme", isAdmin != null && isAdmin);
		
		
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		
		model.addAttribute("listafilmes", filmes);	
		

		if (session.getAttribute("usuarioLogadomome") != null){
			
			return "buscaFilme";
		}else{
			return "redirect:/naoAutorizado";
		}
		
	
	
	}
	



	@RequestMapping(value = "/filmesBusca", method = RequestMethod.POST)
	public String buscarfilme(Model model, String nome, HttpSession session) {

		
		
		Boolean isAdmin = (Boolean) session.getAttribute("usuarioAdmin");
		model.addAttribute("isAdmin", isAdmin != null && isAdmin);
		
		
		
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		
		filmes.clear();
		filmes.addAll(filmeDao.buscaFilmes(nome));
	

		if (session.getAttribute("usuarioLogadomome") != null){
			return "buscaFilme";
			
		}else{
			return "redirect:/naoAutorizado";
		}

		
		
	}

}
