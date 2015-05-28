package filmator.controller;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import filmator.dao.AvaliacaoDao;
import filmator.dao.FilmeDao;
import filmator.dao.UsuarioDao;
import filmator.model.Biblioteca;
import filmator.model.Filme;
import filmator.model.Nota;

@Controller
public class RegistrosController {

	public Biblioteca bibli = new Biblioteca();
	
	@Inject 
	private FilmeDao filmeDao;
	

	@Inject 
	private AvaliacaoDao avaliacaoDao;
	
	@RequestMapping(value = "/filmesSalvos", method = RequestMethod.GET)
	public String mostraCadastrados(Model model,  HttpSession session) {
		Boolean isAdmin = (Boolean) session.getAttribute("usuarioAdmin");
		model.addAttribute("isAdmin", isAdmin != null && isAdmin);
		
		
		
		model.addAttribute("logado", session.getAttribute("usuarioLogadomome"));
		
		model.addAttribute("listafilmes", filmeDao.buscaTodosFilmesJava8());	
		

			
		
		return "registroDeFilmes";
	
	}

	


	@ResponseBody
	@RequestMapping(value = "/avaliar", method = RequestMethod.POST)
	public double salvarNota(int nota, int id, HttpSession session) {
		
		int idusu= (int) session.getAttribute("usuarioLogadoId");
		Nota vNota = new Nota(nota, id, idusu );
		avaliacaoDao.inserir(vNota);
		
		
		
		//double mediaAtual = avaliacaoDao.buscaMediaAtual(idFilme);	
		return avaliacaoDao.mediaAvaliacao(id).get(0).getNota();
		
	}


}
