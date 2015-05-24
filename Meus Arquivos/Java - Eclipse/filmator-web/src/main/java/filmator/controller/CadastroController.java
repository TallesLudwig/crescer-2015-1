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
		model.addAttribute("generos", Genero.values());
				
	

		return "cadastro";
	}

	
	
	
	@RequestMapping(value = "/salvar", method=RequestMethod.POST)
	public String salvar(Filme filme, Model model) {		
			bibli.adicionarFilme(filme);
			
			System.out.println(filme.getNome() );
			System.out.println(filme.getAno() );
			System.out.println(filme.getSinopse() );
			System.out.println(filme.getImagem() );
			System.out.println(bibli.getLista());
			
		return "redirect:/cadastro-filmes";
	}

}

