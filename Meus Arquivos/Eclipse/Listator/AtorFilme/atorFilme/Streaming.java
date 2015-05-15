package atorFilme;

import java.util.ArrayList;

public abstract class Streaming {
	
	private ArrayList<Filme> ListaFilmes= new ArrayList<>();
	private int Com�dia =0;
	private int acao=0;
	private int Aventura=0;
	

	protected void adicionarFilme(Filme filme){ 
		this.ListaFilmes.add(filme);  
	}

	
	
	protected boolean reproduzirFilme(Filme filme){ 
		boolean estaNoAcervo = false ;
		for (int i = 0; i < ListaFilmes.size(); i++) {
		
			if (this.ListaFilmes.get(i) == filme ){
			
				estaNoAcervo= true;	
				
				if(this.ListaFilmes.get(i).getGenero() == Genero.Com�dia ){Com�dia++;}
				if(this.ListaFilmes.get(i).getGenero() == Genero.Acao ){acao++;}
				if(this.ListaFilmes.get(i).getGenero() == Genero.Aventura ){Aventura++;}
				
				
			}	
		
			
		}
		return estaNoAcervo;
		
	}
	protected String geraRelatorio() {
		return "Filmes de comedia : "+this.Com�dia + "\nFilmes de acao : "+ acao+ "\nFilmes de Aventura : "+ Aventura;

	}

	
	protected ArrayList<Filme> getListaFilmes() {
		return this.ListaFilmes;
		
	}
	

}
