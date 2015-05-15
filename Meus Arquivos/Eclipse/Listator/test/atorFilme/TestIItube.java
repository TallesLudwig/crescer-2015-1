package atorFilme;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class TestIItube {
	

	@Test
	public void testAdicionaFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Iltube iltube = new Iltube(); 
	
		
		ArrayList<Filme> esperado= new ArrayList<Filme>(); 
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

		iltube.adicionarFilme(avengers);
		iltube.adicionarFilme(avengers2);
	
		esperado.add(avengers);
		esperado.add(avengers2);
	
        // Assert
        assertEquals(iltube.getListaFilmes(), esperado);
		
		
	}
	
	@Test
	public void testReprodusFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Iltube iltube = new Iltube(); 
	
		
	
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

		iltube.adicionarFilme(avengers);
		iltube.adicionarFilme(avengers2);
		
		
	
		
	
        // Assert
        assertEquals(iltube.reproduzirFilme(avengers2), true);
		
		
	}
	@Test
	public void testNaoReprodusFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Iltube iltube = new Iltube(); 
	
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

	
		iltube.adicionarFilme(avengers2);
		
		
	
		
	
        // Assert
        assertEquals(iltube.reproduzirFilme(avengers), false);
		
		
	}
	
	@Test
	public void testReprodusRelatoria() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Iltube iltube = new Iltube(); 
		String Esperado = new String("Filmes de comedia : 0\nFilmes de acao : 3\nFilmes de Aventura : 0");
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

	
		iltube.adicionarFilme(avengers2);
		
		iltube.reproduzirFilme(avengers2);
		iltube.reproduzirFilme(avengers2);
		iltube.reproduzirFilme(avengers2);
		
	
		
	
        // Assert
        assertEquals(iltube.geraRelatorio(), Esperado);
		
		
	}
	
	@Test
	public void testReprodusRelatoriaDeVarios() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme DeL = new Filme("Debi e Loid",Genero.Com�dia);
		Filme Idiana = new Filme("Idiana Jones",Genero.Aventura);
		
		Iltube iltube = new Iltube(); 
		String Esperado = new String("Filmes de comedia : 2\nFilmes de acao : 2\nFilmes de Aventura : 2");
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		DeL.novoAtor(ator3);
		

	
		iltube.adicionarFilme(avengers);
		iltube.adicionarFilme(DeL);
		iltube.adicionarFilme(Idiana);
		
		iltube.reproduzirFilme(avengers);
		iltube.reproduzirFilme(avengers);
		
		iltube.reproduzirFilme(DeL);
		iltube.reproduzirFilme(DeL);
		
		iltube.reproduzirFilme(Idiana);
		iltube.reproduzirFilme(Idiana);
		
	
		
	
        // Assert
        assertEquals(iltube.geraRelatorio(), Esperado);
		
		
	}

}
