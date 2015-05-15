package apis;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

public class MapTest {
	@Test /// e Put
	public void mapGet(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
	   String val=(String)map.get(3);
	   
	   // check the value
	   assertEquals(val, "Software" );
	}
	
	@Test /// e Put
	public void mapGet2(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
	   String val=(String)map.get(2);
	   
	   // check the value
	   assertEquals(val, "Cwi" );
	}
	
	
	@Test 
	public void mapcontainsKeyTrue(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
		
	   
	   // check the value
	   assertEquals(map.containsKey(2), true );
	}
	
	@Test 
	public void mapcontainsKeyFalse(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
		
	   
	   // check the value
	   assertEquals(map.containsKey(54), false );
	}
	
	@Test 
	public void mapContainsValueTrue(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
		
	   
	   // check the value
	   assertEquals(map.containsValue("Cwi"), true );
	}
	
	@Test 
	public void mapContainsValueFalse(){
		
		HashMap<Integer, String> map = new HashMap<>();
    
	   // populate hash map
		map.put(1, "Crescer");
		map.put(2, "Cwi");
		map.put(3, "Software");
	      
	   // get value of key 3
		
	   
	   // check the value
	   assertEquals(map.containsValue("cwi"), false );
	}

}
