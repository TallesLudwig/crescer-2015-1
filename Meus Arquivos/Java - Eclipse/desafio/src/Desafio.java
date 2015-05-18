import java.util.ArrayList;
import java.util.List;

public class Desafio {
	
	List<Integer> lista = new ArrayList<>();
	
	public List<Integer> getLista() {
		return lista;
	}


	public Desafio() {
	

	}
	
	
	public void indiceMaiusculas(String frase){
		for (int i = 0;i < frase.length(); i++){			
			if(Character.isUpperCase(frase.charAt(i))	 ){
				
				lista.add(i);
			}	
		}
	}
	


}
