package mestreCuca;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestLivroReceita {
	
	@Test	
	public void criaLivro()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test
	public void criaEAlteraLivro() throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		
		Livro.atualizar("Pao", receita2);
		
		List<Receita> esperado = new ArrayList<>();
		
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

	}
	
	
	@Test	
	public void criaEDeletaLivro()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
				
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		Livro.excluir("Pao2");
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
	}
	
	
	@Test	
	public void criaBuscaLivro()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		
		
		
		assertEquals(Livro.buscaReceitaPeloNome("Pao"), esperado.get(0) );		

		
		
	}
	
	@Test(expected= NullPointerException.class)	
	public void criaBuscaLivroExec()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		

		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
	
		

		
		
		assertEquals(Livro.buscaReceitaPeloNome("Bolo"), 1);		

		
		
	}
	
	@Test(expected= NullPointerException.class)		
	public void criaNomeNull()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita(null, Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test(expected= NullPointerException.class)		
	public void criaNomeSemNada()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test
	public void cria2Nome()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes2);
		receita.addIngredientes(Ingredientes);
		
		
		LivroReceita Livro = new LivroReceita();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	

}
