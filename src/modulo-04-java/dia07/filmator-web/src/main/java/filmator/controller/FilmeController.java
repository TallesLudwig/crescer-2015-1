package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.model.Filme;
import filmator.model.Genero;

@Controller
public class FilmeController {

	//DAO === data access object, convenção para nomes de classes que conectam no banco
	private FilmeDao dao = new FilmeDao();
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {		
		model.addAttribute("generos", Genero.values());
		model.addAttribute("mensagem", "Bem vindo, blablabla");
		model.addAttribute("listaFilmes", dao.buscaTodosFilmes());
		return "telaCadastro";
	}
	
	
	@RequestMapping(value = "/salvar", method = RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
		System.out.println(filme.getNome());
		dao.salvar(filme);
		model.addAttribute("generos", Genero.values());
		model.addAttribute("mensagem", "Filme salvo com sucesso");
		model.addAttribute("listaFilmes", dao.buscaTodosFilmes());
		return "telaCadastro";
	}
}

