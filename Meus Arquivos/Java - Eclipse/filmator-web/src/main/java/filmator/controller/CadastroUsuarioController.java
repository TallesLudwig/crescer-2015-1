package filmator.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Usuario;

@Controller
public class CadastroUsuarioController {
	
	@Inject 
	private UsuarioDao usuarioDao;
	
	
	@RequestMapping(value = "/cadastro-usuario", method=RequestMethod.GET)
	public String abreTelaCadastro(Usuario usuario, Model model, HttpSession session) {
		model.addAttribute("logado", "Deslogado");
	
		return "cadastroUsuario";
	}


	@RequestMapping(value = "/salvarUsuario", method = RequestMethod.POST)
	public String salvar(Model model, Usuario usuario) {
	
		usuarioDao.inserir(usuario);

		
		return "redirect:/login";
		
	}

	

}
