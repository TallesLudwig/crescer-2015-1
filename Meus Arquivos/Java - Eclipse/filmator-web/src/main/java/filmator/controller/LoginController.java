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
		model.addAttribute("mensagem", "Informe os dados:");
		model.addAttribute("logado", "Deslogado");
	
		return "login";
	}
	
	
	@RequestMapping(value = "/entrar", method = RequestMethod.POST)
	public String salvar(Model model, Usuario usuario, HttpSession session) {
	
		if(  usuarioDao.buscaUsuario(usuario) != null ){
			
			session.setAttribute("usuarioLogadomome", usuarioDao.buscaUsuario(usuario).get(0).getNome());
			session.setAttribute("usuarioLogado", usuario);
			session.setAttribute("usuarioAdmin", usuarioDao.buscaUsuario(usuario).get(0).getAdmin());
			System.out.println(usuarioDao.buscaUsuario(usuario).get(0).getAdmin());
			
			
		} else {
			System.out.println("Não entro");
			
		}
			
			return "redirect:/";
		
		
	}
	
	


	

}
