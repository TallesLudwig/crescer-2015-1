package filmator.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class NaoAutorizado {

	@RequestMapping(value = "/naoAutorizado", method = RequestMethod.GET)
	public String home(Model model, HttpSession session) {
		

		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		
		model.addAttribute("mensagem", "OOOOOOoops");
		model.addAttribute("texto",
				"Sinto muito mas voce não tem autorição para entrar nesta pagina. Tente fazer login com um usuario autorizado");

		return "naoAutorizado";
	}

}
