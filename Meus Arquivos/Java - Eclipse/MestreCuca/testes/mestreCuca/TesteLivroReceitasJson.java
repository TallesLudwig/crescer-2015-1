package mestreCuca;




import org.junit.Test;

public class TesteLivroReceitasJson {
	
	
	@Test	
	public void criarReceita()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER, 5);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS, 10.5);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		String caminho = new String("C:\\Users\\0152067\\Crescer Pai\\Meus Arquivos\\Java - Eclipse\\MestreCuca\\Json");
		
		LivroReceitasJson Livro = new LivroReceitasJson(caminho, "receitas");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		Receita receita2 = new Receita("Pao2", Instrucao);
		receita2.addIngredientes(Ingredientes2);
		receita2.addIngredientes(Ingredientes);
	
		
		Livro.inserir(receita);
		Livro.atualizar("Pao", receita2);

		
	}

}
