package filmator.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.mockito.InjectMocks;
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
import filmator.model.Usuario;

@Controller
public class HomeController {
	

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {

		Boolean isUser =  (Boolean) session.getAttribute("usuarioAdmin");
		
		Boolean isAdmin =  (Boolean) session.getAttribute("usuarioAdmin");
		
		model.addAttribute("isAdmin", isAdmin != null && isAdmin);
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		model.addAttribute("mensagem", "Bem vindo.");
		model.addAttribute("texto", "	Lorem ipsum dolor sit amet, condimentum libero mus, neque congue ac lacus. Mattis ad molestie metus penatibusLorem ipsum dolor sit amet, condimentum libero mus, neque congue ac lacus. Mattis ad molestie metus penatibusLorem ipsum dolor sit amet, condimentum libero mus, neque congue ac lacus. Mattis ad molestie metus penatibusLorem ipsum dolor sit amet, condimentum libero mus, neque congue ac lacus.");
		
		
		if (session.getAttribute("usuarioLogadomome") != null){
			return "nomeDoArquivo";
		}else{
			return "redirect:/naoAutorizado";
		}
	}
	
	


	

}

