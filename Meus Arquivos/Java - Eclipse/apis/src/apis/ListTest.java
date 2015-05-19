package apis;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ListTest {


	@Test	
	public void listGetInt()throws Exception{
		List<Integer> lista = new ArrayList<>();
		lista.add(3);
		lista.add(2);
		lista.add(1);

		Integer esperado = 3 ; 
		
		assertEquals(lista.get(0), esperado );
		
	}
	
	@Test	
	public void listGetString(){
		List<String> lista = new ArrayList<>();
		lista.add("Crescer");
		lista.add("CWI");
		lista.add("Software");

		String esperado = "Software" ; 
		
		assertEquals(lista.get(2), esperado );
		
	}
	
	@Test	
	public void listSet(){
		List<String> lista = new ArrayList<>();
		lista.add("Crescer");
		lista.add("CWI");
		lista.add("Software");

		lista.set(2, "hardware");
		
		String esperado = "hardware" ; 
		
		assertEquals(lista.get(2), esperado );
		
	}
	

	@Test	
	public void listIndexOf(){
		
		List<String> lista = new ArrayList<>();
		lista.add("Crescer");
		lista.add("CWI");
		lista.add("Software");

		
		
		
		
		assertEquals(lista.indexOf("CWI"), 1 );
		
	}
	

	@Test	
	public void listIndexOf2(){
		
		List<String> lista = new ArrayList<>();
		lista.add("Crescer");
		lista.add("CWI");
		lista.add("Software");

		lista.set(2, "hardware");
		
		
		
		assertEquals(lista.indexOf("Software"), -1 );
		
	}
	
	

}
