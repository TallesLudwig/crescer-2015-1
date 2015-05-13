package atorFilme;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class TestAtorFilm {

	@Test
	public void testCriaAdicionaFilme() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
	
		
		ArrayList<Ator> a= new ArrayList<Ator>(); 
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		a.add(ator1);
		a.add(ator2);
	
        // Assert
        assertEquals(avengers.getListaAtores(), a);
		
		
	}
	@Test
	public void testCriaAdicionaFilmeeBusca1() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		
		Filme avengers = new Filme("avengers", Genero.Acao);
	
		
		ArrayList<Ator> esperado= new ArrayList<Ator>(); 
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		
	
		esperado.add(ator2);
	
        // Assert
        assertEquals(avengers.buscaAtor("Jr"), esperado);
		
		
	}
	@Test
	public void testCriaAdicionaFilmeeBusca2() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		
		Filme avengers = new Filme("avengers", Genero.Acao);
	
		
		ArrayList<Ator> esperado= new ArrayList<Ator>(); 
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		
		esperado.add(ator1);
		esperado.add(ator2);
	
        // Assert
        assertEquals(avengers.buscaAtor("t"), esperado);
		
		
	}
	

}
