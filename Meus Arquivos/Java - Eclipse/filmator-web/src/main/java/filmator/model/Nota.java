package filmator.model;

public class Nota {
	private int nota;
	private int idFilme;
	private int idUsuario;

	
	public Nota(){
		
	}
	
	public Nota(int nota){
	this.nota = nota;
	}
	
	public Nota(int nota, int idFilm,int idUsu){
		this.nota = nota;
		this.idFilme = idFilm;
		this.idUsuario = idUsu;
	}
	



	public int getNota() {
		return nota;
	}


	public void setNota(int nota) {
		this.nota = nota;
	}

	public int getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(int idFilme) {
		this.idFilme = idFilme;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	

}
