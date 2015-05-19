package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class Receita {
	
	private String Nome;
	private List<Ingredientes> Ingredientes = new ArrayList<>();
	private Instrucao instrucao ;
	private double ValorTotal ;
	
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
	 
	 public double getValorTotal(){
		 
		 for (int i = 0;i < Ingredientes.size(); i++){			
			 
			 ValorTotal += Ingredientes.get(i).getValor();
				
			}
		 	
		 return ValorTotal;
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
