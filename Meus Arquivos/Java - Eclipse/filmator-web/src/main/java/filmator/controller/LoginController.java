package filmator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.mockito.InjectMocks;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Biblioteca;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class LoginController {
	
	@Inject 
	private UsuarioDao usuarioDao;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("mensagem", "Bem vindo.");
		
	
		return "login";
	}
	
	
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String salvar(Model model, Usuario usuario) {
	
		
		if(  usuarioDao.autentica(usuario) == 1 ){
			
			System.out.println("entro");
		} else {
			System.out.println("Não entro");
			
		}
			
			return "redirect:/";
		
		
	}

	

}
