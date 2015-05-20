package mestreCuca;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestLivroReceita {
	private static final double DELTA = 1e-15;
	
	@Test	
	public void criaLivro()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test
	public void criaEAlteraLivro() throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		
		Livro.atualizar("Pao", receita2);
		
		List<Receita> esperado = new ArrayList<>();
		
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

	}
	
	
	@Test	
	public void criaEDeletaLivro()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
				
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		Livro.excluir("Pao2");
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
	}
	
	
	@Test	
	public void criaBuscaLivro()throws Exception{
		
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		
		
		
		assertEquals(Livro.buscaReceitaPeloNome("Pao"), esperado.get(0) );		

		
		
	}
	
	@Test(expected= NullPointerException.class)	
	public void criaBuscaLivroExec()throws Exception{
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		

		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
	
		

		
		
		assertEquals(Livro.buscaReceitaPeloNome("Bolo"), 1);		

		
		
	}
	
	@Test(expected= NullPointerException.class)		
	public void criaNomeNull()throws Exception{
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita(null, Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test(expected= NullPointerException.class)		
	public void criaNomeSemNada()throws Exception{
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test
	public void cria2Nome()throws Exception{
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		assertEquals(Livro.getTodasReceitas(), esperado );		

		
		
	}
	
	@Test	
	public void testValorListar()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
		esperado.add(receita2);
		
		
		
		assertEquals(Livro.valorReceitas(esperado), 20.5 , DELTA );		

		
		
	}
	
	@Test	
	public void testAlergico()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita);
	
		
		List<Ingredientes> alaergicos = new ArrayList<>();
		
		alaergicos.add(Ingredientes2);
		
		assertEquals(Livro.ProtecaoAlergicos(alaergicos), esperado  );		

		
		
	}
	@Test	
	public void testAlergicoAtudo()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		List<Receita> esperado = new ArrayList<>();
	
	
		
		List<Ingredientes> alaergicos = new ArrayList<>();
		alaergicos.add(Ingredientes);
		alaergicos.add(Ingredientes2);
		
		assertEquals(Livro.ProtecaoAlergicos(alaergicos), esperado  );		

		
		
	}
	
	@Test	
	public void testAlergico2()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		Ingredientes Ingredientes3= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);

		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes3);
		receita2.addIngredientes(Ingredientes);
		
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		
		
		List<Receita> esperado = new ArrayList<>();
		
	
		
		List<Ingredientes> alergicos = new ArrayList<>();
		alergicos.add(Ingredientes3);
		alergicos.add(Ingredientes2);
		
		assertEquals(Livro.ProtecaoAlergicos(alergicos), esperado  );		

		
		
	}
	
	@Test	
	public void testAlergico3()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		Ingredientes Ingredientes3= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);

		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes3);
		receita2.addIngredientes(Ingredientes);
		
		Receita receita3 = new Receita("Pao2", Instrucao);
	
		receita3.addIngredientes(Ingredientes);
		
		
		Livro Livro = new Livro();
		Livro.inserir(receita);
		Livro.inserir(receita2);
		Livro.inserir(receita3);
		
		
		List<Receita> esperado = new ArrayList<>();
		esperado.add(receita3);
		
		List<Ingredientes> alergicos = new ArrayList<>();
		alergicos.add(Ingredientes3);
		alergicos.add(Ingredientes2);
		
		assertEquals(Livro.ProtecaoAlergicos(alergicos), esperado  );		

		
		
	}
	
	
	@Test	
	public void testListaDeCompras()throws Exception{
		
		Ingredientes Sal= new Ingredientes("Sal", 1, Unidade.COLHERdeSOPA, 20);
		Ingredientes arroz3= new Ingredientes("arroz", 3, Unidade.KILOS, 10.5);
		Ingredientes condensado= new Ingredientes("leite condensado", 1, Unidade.LATA, 10.5);
		
		
		Ingredientes arroz1= new Ingredientes("arroz", 1, Unidade.XICARAS, 10.5);
		
		Ingredientes Carne= new Ingredientes("carne", 1, Unidade.KILOS, 10.5);


		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita Arrozdeforno = new Receita("Arroz de forno", Instrucao);
		Arrozdeforno.addIngredientes(Sal);
		Arrozdeforno.addIngredientes(arroz3);
		
		
		
		Receita Arrozdoce  = new Receita("Arroz doce", Instrucao);
		Arrozdoce.addIngredientes(arroz1);
		Arrozdoce.addIngredientes(condensado);
		
		
		
		Receita CarneDePanela = new Receita("CarneDePanela", Instrucao);
	
		CarneDePanela.addIngredientes(Carne);
		CarneDePanela.addIngredientes(Sal);
		
	
		
		Livro Livro = new Livro();
		Livro.inserir(Arrozdeforno);
		Livro.inserir(Arrozdoce);
		Livro.inserir(CarneDePanela);
		
		List<Receita> Compras = new ArrayList<>();
		Compras.add(Arrozdeforno);
		Compras.add(Arrozdoce);
		Compras.add(CarneDePanela);
		
		
		
		
		List<String> esperado = new ArrayList<>();
		esperado.add("3.0 KILOS arroz");
		esperado.add("1.0 XICARAS arroz");
		esperado.add("2.0 COLHERdeSOPA Sal");
		esperado.add("1.0 LATA leite condensado");
		esperado.add("1.0 KILOS carne");

		
		assertEquals(Livro.listaDeCompras(Compras), esperado  );		

		
		
	}
	
	
	
	@Test	
	public void testListaDeCompras2()throws Exception{
		
		Ingredientes Sal= new Ingredientes("Sal", 1, Unidade.COLHERdeSOPA, 20);
		Ingredientes arroz3= new Ingredientes("arroz", 3, Unidade.XICARAS, 10.5);
		Ingredientes condensado= new Ingredientes("leite condensado", 1, Unidade.LATA, 10.5);
		
		
		Ingredientes arroz1= new Ingredientes("arroz", 1, Unidade.XICARAS, 10.5);
		
		Ingredientes Carne= new Ingredientes("carne", 1, Unidade.KILOS, 10.5);
		
		Ingredientes Carne2= new Ingredientes("carne", 500.51, Unidade.GRAMAS, 10.5);


		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita Arrozdeforno = new Receita("Arroz de forno", Instrucao);
		Arrozdeforno.addIngredientes(Sal);
		Arrozdeforno.addIngredientes(arroz3);
		
		
		
		Receita Arrozdoce  = new Receita("Arroz doce", Instrucao);
		Arrozdoce.addIngredientes(arroz1);
		Arrozdoce.addIngredientes(condensado);
		
		
		
		Receita CarneDePanela = new Receita("CarneDePanela", Instrucao);
	
		CarneDePanela.addIngredientes(Carne);
		CarneDePanela.addIngredientes(Carne2);
		CarneDePanela.addIngredientes(Sal);
		
	
		
		Livro Livro = new Livro();
		Livro.inserir(Arrozdeforno);
		Livro.inserir(Arrozdoce);
		Livro.inserir(CarneDePanela);
		
		List<Receita> Compras = new ArrayList<>();
		Compras.add(Arrozdeforno);
		Compras.add(Arrozdoce);
		Compras.add(CarneDePanela);
		
		
		
		
		List<String> esperado = new ArrayList<>();
		esperado.add("4.0 XICARAS arroz");
		esperado.add("2.0 COLHERdeSOPA Sal");
		esperado.add("1.0 LATA leite condensado");
		esperado.add("1.0 KILOS carne");
		esperado.add("500.51 GRAMAS carne");

		
		assertEquals(Livro.listaDeCompras(Compras), esperado  );		

		
		
	}
	

}
