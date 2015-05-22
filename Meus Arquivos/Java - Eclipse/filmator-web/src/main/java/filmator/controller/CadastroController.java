package filmator.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.model.Biblioteca;
import filmator.model.Filme;
import filmator.model.Genero;


@Controller
public class CadastroController {
	
	
	public Biblioteca bibli = new Biblioteca();


	@RequestMapping(value = "/cadastro-filmes", method=RequestMethod.GET)
	public String abreTelaCadastro(Filme filme, Model model) {
		model.addAttribute("generos",Genero.values());
				
		model.addAttribute("mensagem", "Filme"+ filme.getNome() +" Cadastrado com sucesso!!");

		return "cadastro";
	}

	
	
	
	@RequestMapping(value = "/salvar", method=RequestMethod.POST)
	public String salvar(Filme filme, Model model) {
			System.out.println(filme.getNome());
			bibli.adicionarFilme(filme);
			
			model.addAttribute("mensagem", "Filme"+ filme.getNome() +" Cadastrado com sucesso!!");
			System.out.println(bibli.getLista());
			
		return "redirect:/cadastro-filmes";
	}

}

