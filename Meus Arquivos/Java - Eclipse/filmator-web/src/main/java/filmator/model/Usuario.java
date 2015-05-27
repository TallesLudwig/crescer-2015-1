package filmator.model;

public class Usuario {
	private String login;
	private String nome;
	private String senha;
	private int admin;
	
	public Usuario(){
		
	}
	
	public Usuario(String login,  String senha ){

		this.login = login;
		this.senha = senha;
		
	}
	
	public Usuario(String login, String nome, String senha ){

		this.login = login;
		this.nome = nome;
		this.senha = senha;
		
	}

	

	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public int getAdmin() {
		return admin;
	}

	public void setAdmin(int admin) {
		this.admin = admin;
	}
	
	 
	
	
	
	
}
