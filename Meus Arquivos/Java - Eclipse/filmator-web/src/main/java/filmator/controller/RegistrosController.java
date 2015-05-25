package filmator.controller;

import java.util.ArrayList;
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

@Controller
public class RegistrosController {

	public Biblioteca bibli = new Biblioteca();
	
	@Inject 
	private FilmeDao filmeDao;
	
/*@RequestMapping(value = "/filmesSalvos", method=RequestMethod.GET)
	public String mostraCadastrados( Model model) {
		
		for (Filme a : bibli.getLista()) {
		
			model.addAttribute("nome", a.getNome() );
			model.addAttribute("ano", a.getAno() );
			model.addAttribute("listaFilmes", bibli.getLista());		
			model.addAttribute("sinopse", a.getSinopse() );
			model.addAttribute("imagem", a.getImagem() );
			
			
		}
	
	
		return "registroDeFilmes";
	}*/
	
	//@ResponseBody //@ResponseBody faz transformar o retorno para JSON!
	@RequestMapping(value = "/filmesSalvos", method = RequestMethod.GET)
	public String mostraCadastrados(Model model) {
		
		
		for (Filme a : filmeDao.buscaTodosFilmesJava8()) {
			
			model.addAttribute("nome", a.getNome() );
			System.out.print(a.getAno());
			model.addAttribute("ano", a.getAno() );
			System.out.print(a.getGenero().getDescricao());
			model.addAttribute("genero.descricao", a.getGenero().getDescricao());	
			System.out.print(a.getSinopse());
			model.addAttribute("sinopse", a.getSinopse() );
			System.out.print(a.getImagem());
			model.addAttribute("imagem", a.getImagem() );
			System.out.println("-");
			
			
		}
		
		return "registroDeFilmes";
	
	}


}
