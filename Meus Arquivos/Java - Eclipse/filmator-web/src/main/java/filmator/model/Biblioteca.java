package filmator.model;

import java.util.ArrayList;



public class Biblioteca {
	private ArrayList<Filme> lista = new ArrayList<>();
	
	public Biblioteca(){
		
	}
	
	public void adicionarFilme(Filme filme) {
		this.lista.add(filme);
	}

	public ArrayList<Filme> getLista() {
		return lista;
	}

}
