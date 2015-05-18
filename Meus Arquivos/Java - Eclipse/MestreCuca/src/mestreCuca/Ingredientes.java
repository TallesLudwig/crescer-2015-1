package mestreCuca;

public class Ingredientes {
	
	private String Nome;
	private double Quantidade;
	private Unidade unidade;
	
	
	
	public Ingredientes(String nome, double quantidade, Unidade unidade){
		
		this.Nome= nome;
		this.Quantidade= quantidade;
		this.unidade=unidade;
		
	}
	
	
	
	public double getQuantidade() {
		return Quantidade;
	}



	public Unidade getUnidade() {
		return unidade;
	}



	public String getNome() {
		return Nome;
	}


}
