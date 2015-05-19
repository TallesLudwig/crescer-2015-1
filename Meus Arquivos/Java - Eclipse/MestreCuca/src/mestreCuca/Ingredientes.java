package mestreCuca;

public class Ingredientes {
	
	private String Nome;
	private double Quantidade;
	private Unidade unidade;
	private double Valor;
	
	
	
	public Ingredientes(String nome, double quantidade, Unidade unidade, double valor){
		
		this.Nome= nome;
		this.Quantidade= quantidade;
		this.unidade=unidade;
		this.Valor = valor;
		
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
	
	public double getValor() {
		
		return Valor;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Nome.toString();
	}


}
