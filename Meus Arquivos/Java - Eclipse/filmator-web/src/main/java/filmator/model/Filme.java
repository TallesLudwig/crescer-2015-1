package filmator.model;

public class Filme {

	private String nome;
	private int ano;
	private Genero genero;
	
	public Filme(){
	
	}
	
	
	public Filme(String nome, int ano){
		this.nome = nome;
		this.setAno(ano);
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getNome() {
		return nome;
	}


	public int getAno() {
		return ano;
	}


	public void setAno(int ano) {
		this.ano = ano;
	}
}
