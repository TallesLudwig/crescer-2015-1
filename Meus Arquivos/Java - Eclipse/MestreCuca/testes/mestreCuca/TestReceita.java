package mestreCuca;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class TestReceita {

	@Test	
	public void criarReceita()throws Exception{
		
		Ingredientes Ingredientes= new Ingredientes("Sal", 2, Unidade.COLHER);
		Ingredientes Ingredientes2= new Ingredientes("Farinha", 1, Unidade.XICARAS);
		
		Instrucao Instrucao= new Instrucao("Vai la campeao");
		
		Receita receita = new Receita("Pao", Instrucao);
		receita.addIngredientes(Ingredientes);
		receita.addIngredientes(Ingredientes2);
		

		Instrucao esperadadoInstrucao= new Instrucao("Vai la campeao");
		
		List<Ingredientes> esperadoIngredientes = new ArrayList<>();
		esperadoIngredientes.add(Ingredientes);
		esperadoIngredientes.add(Ingredientes2);
		
		
		assertEquals(receita.getInstrucao().getInstrucao(), esperadadoInstrucao.getInstrucao() );		
		assertEquals(receita.getIngredientes(), esperadoIngredientes );		
		assertEquals(receita.getIngredientes().get(0).getUnidade(), Unidade.COLHER );
		
		
	}

}
