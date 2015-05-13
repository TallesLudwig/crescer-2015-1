package atorFilme;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

public class testNetFlox {
	

	@Test
	public void testAdicionaFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Netflox netflox = new Netflox(); 
	
		
		ArrayList<Filme> esperado= new ArrayList<Filme>(); 
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

		netflox.adicionarFilme(avengers);
		netflox.adicionarFilme(avengers2);
	
		esperado.add(avengers);
		esperado.add(avengers2);
	
        // Assert
        assertEquals(netflox.getListaFilmes(), esperado);
		
		
	}
	
	@Test
	public void testReprodusFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Netflox netflox = new Netflox(); 
	
		
	
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

		netflox.adicionarFilme(avengers);
		netflox.adicionarFilme(avengers2);
		
		
	
		
	
        // Assert
        assertEquals(netflox.reproduzirFilme(avengers2), true);
		
		
	}
	@Test
	public void testNaoReprodusFilmeaFlox() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Netflox netflox = new Netflox(); 
	
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

	
		netflox.adicionarFilme(avengers2);
		
		
	
		
	
        // Assert
        assertEquals(netflox.reproduzirFilme(avengers), false);
		
		
	}
	
	@Test
	public void testReprodusRelatoria() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme avengers2 = new Filme("avengers 2",Genero.Acao);
		
		Netflox netflox = new Netflox(); 
		String Esperado = new String("Filmes de comedia : 0\nFilmes de acao : 2\nFilmes de Aventura : 0");
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		avengers2.novoAtor(ator3);
		

	
		netflox.adicionarFilme(avengers2);
		
		netflox.reproduzirFilme(avengers2);
		netflox.reproduzirFilme(avengers2);
		
	
		
	
        // Assert
        assertEquals(netflox.geraRelatorio(), Esperado);
		
		
	}
	
	@Test
	public void testReprodusRelatoriaDeVarios() throws Exception {
		Ator ator1 = new Ator("Scarlett Johansson ");
		Ator ator2 = new Ator("Robert Downey Jr");
		Ator ator3 = new Ator("elizabeth olsen");
		
		Filme avengers = new Filme("avengers",Genero.Acao);
		Filme DeL = new Filme("Debi e Loid",Genero.Com�dia);
		Filme Idiana = new Filme("Idiana Jones",Genero.Aventura);
		
		Netflox netflox = new Netflox(); 
		String Esperado = new String("Filmes de comedia : 2\nFilmes de acao : 2\nFilmes de Aventura : 2");
		
        // Act

		avengers.novoAtor(ator1);
		avengers.novoAtor(ator2);
		DeL.novoAtor(ator3);
		

	
		netflox.adicionarFilme(avengers);
		netflox.adicionarFilme(DeL);
		netflox.adicionarFilme(Idiana);
		
		netflox.reproduzirFilme(avengers);
		netflox.reproduzirFilme(avengers);
		
		netflox.reproduzirFilme(DeL);
		netflox.reproduzirFilme(DeL);
		
		netflox.reproduzirFilme(Idiana);
		netflox.reproduzirFilme(Idiana);
		
	
		
	
        // Assert
        assertEquals(netflox.geraRelatorio(), Esperado);
		
		
	}

}
