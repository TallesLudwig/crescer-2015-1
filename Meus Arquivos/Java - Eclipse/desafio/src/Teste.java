
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class Teste {

	@Test
	public void testeFrase()throws Exception{
		Desafio a = new Desafio();
		List<Integer> lista = new ArrayList<>();
		a.indiceMaiusculas("CWI SoFtware");
	
		lista.add(0);
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(6);
		
		
		assertEquals(a.getLista(), lista );
		
	}
	
	@Test
	public void testeFraseComUnderline()throws Exception{
		Desafio a = new Desafio();
		List<Integer> lista = new ArrayList<>();
		a.indiceMaiusculas("Cwi_software");
	
		lista.add(0);
				
		
		assertEquals(a.getLista(), lista );
		
	}
	
	
	@Test
	public void testeFrase2()throws Exception{
		Desafio a = new Desafio();
		List<Integer> lista = new ArrayList<>();
		a.indiceMaiusculas("CWI SOFtware");
	
		lista.add(0);
		lista.add(1);
		lista.add(2);
		lista.add(4);
		lista.add(5);
		lista.add(6);
		
		
		assertEquals(a.getLista(), lista );
		
	}
	
	@Test
	public void testeFrase0()throws Exception{
		Desafio a = new Desafio();
		List<Integer> lista = new ArrayList<>();
		a.indiceMaiusculas("cwi software");

		assertEquals(a.getLista(), lista );
		
	}
}
