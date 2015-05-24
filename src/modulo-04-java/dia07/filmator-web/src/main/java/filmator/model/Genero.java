package filmator.model;

public enum Genero {
	COMEDIA("Comédia"),
	ACAO("Ação"),
	FICCAO_CIENTIFICA("Ficção Científica");
	
	private String descricao;

	private Genero(String descricao){
		this.descricao = descricao;
	}
	public String getDescricao() {
		return descricao;
	}
	
}
