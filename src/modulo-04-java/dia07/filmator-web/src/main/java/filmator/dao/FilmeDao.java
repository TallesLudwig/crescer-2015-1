package filmator.dao;

import java.util.ArrayList;
import java.util.List;

import filmator.model.Filme;

public class FilmeDao {

	private static List<Filme> filmesSalvos = new ArrayList<Filme>();
	
	public List<Filme> buscaTodosFilmes(){
		return filmesSalvos;
	}

	public void salvar(Filme filme) {
		filmesSalvos.add(filme);
	}
}
 