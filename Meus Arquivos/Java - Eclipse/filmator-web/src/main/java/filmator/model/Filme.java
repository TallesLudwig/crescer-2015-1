package filmator.model;

public class Filme {

	private String nome;
	private int ano;
	private Genero genero;
	private String sinopse;
	private String imagem;
	
	public Filme(){
	
	}
	
	
	public Filme(String nome, int ano, Genero genero, String sinopse, String imagem ){
		this.nome = nome;
		this.setAno(ano);
		this.setGenero(genero);
		this.sinopse= sinopse;
		this.imagem= imagem;
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


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}


	public String getSinopse() {
		return sinopse;
	}


	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}


	public String getImagem() {
		return imagem;
	}


	public void setImagem(String imagem) {
		this.imagem = imagem;
	}
	
	
	
}
