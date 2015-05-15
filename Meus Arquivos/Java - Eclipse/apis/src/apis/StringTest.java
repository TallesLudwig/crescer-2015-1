package apis;

import static org.junit.Assert.*;

import org.junit.Test;

public class StringTest {

	@Test	
	public void stringToUpperCase(){
		String valor = "cwi";
		String Esperado = "CWI";
		
		assertEquals(valor.toUpperCase(), Esperado);
		
		
	}
	@Test	
	public void stringToLowerCase(){
		String Esperado  = "cwi";
		String valor = "CWI";
		
		assertEquals(valor.toLowerCase(), Esperado);
		
		
	}
	
	@Test	
	public void stringIndexOfTemTodo(){
		String valor = "cwi";
		int Esperado = 0;
		
		assertEquals(valor.indexOf(valor), Esperado);	
		
	}
	
	@Test
	public void stringIndexOf2(){
		String valor = "cwi";
		int Esperado = 2;
		
		assertEquals(valor.indexOf("i"), Esperado);	
		
	}
	
	@Test
	public void stringIndexOfNaoTem(){
		String valor = "cwi";
		int Esperado =-1;
		
		assertEquals(valor.indexOf("t"), Esperado);	
		
	}
	
	

	@Test
	public void stringReplaceSoftware(){
		String valor = "cwi Software";
		String esperado = "cwi Crescer";
		
		assertEquals(valor.replace("Software", "Crescer"),esperado );
		
	}
	@Test
	public void stringReplaceSpace(){
		String valor = "Crescer cwi Software";
		String esperado = "Crescer-cwi-Software";
		
		assertEquals(valor.replace(" ", "-"),esperado );
		
	}
	
	@Test
	public void stringSplit(){
		
		String valor = "Crescer-cwi-Software";
	
		String splits[]= valor.split("-");
		
		
		assertEquals(splits[0] ,"Crescer" );
		assertEquals(splits[1] ,"cwi" );
		assertEquals(splits[2] ,"Software" );
		
	}
	

}
