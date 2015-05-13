package atorFilme;

import java.util.ArrayList;


public class Filme {
	
	private String NomeFilme;
	private ArrayList<Ator> ListaAtores= new ArrayList<>();
	private ArrayList<Ator> ListaAtoresComNome= new ArrayList<>();
	protected Genero genero;
	
	public Filme(String Nome, Genero genero)
	    {
		   this.NomeFilme= Nome;
	       this.genero = genero;
	    }

	  
	public ArrayList<Ator> buscaAtor(String nome){
		for (int i = 0; i < ListaAtores.size(); i++) {
			if (this.ListaAtores.get(i).getNome().contains(nome) == true ){
			
				ListaAtoresComNome.add(ListaAtores.get(i));
				
				
			}	
			
		}
		return ListaAtoresComNome;
		
	}
	
	
	public void novoAtor(Ator ator){
		
		this.ListaAtores.add(ator);   
		
	}

	public String getNome() {
		return NomeFilme;
	}
	
	public ArrayList<Ator> getListaAtores() {
		return ListaAtores;
		
	}


	public Genero getGenero() {
		return genero;
	}

}





