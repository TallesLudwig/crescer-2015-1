package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	private String Nome;
	private List<Ingredientes> Ingredientes = new ArrayList<>();
	private Instrucao instrucao ;
	
	public Receita(String nome,  Instrucao instrucao){
		if(nome =="" || nome==null){
			throw new NullPointerException();
			
		} else {
		this.Nome= nome;
		this.instrucao= instrucao;
		}
		
	}
	 public void addIngredientes(Ingredientes ingredientes){
		 
		 Ingredientes.add(ingredientes);
		 
	 }

	public String getNome() {
		return Nome;
	}

	public List<Ingredientes> getIngredientes() {
		return Ingredientes;
	}

	public Instrucao getInstrucao() {
		return instrucao;
	}
	

}
