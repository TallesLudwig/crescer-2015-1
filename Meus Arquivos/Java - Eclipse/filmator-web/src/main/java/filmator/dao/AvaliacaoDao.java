package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import filmator.model.Filme;
import filmator.model.Genero;
import filmator.model.Nota;
import filmator.model.Usuario;



@Component
public class AvaliacaoDao {

	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
	public void inserir(Nota nota){
			
			
			jdbcTemplate.update("INSERT INTO AVALIACAO (idfilme, idusuario, nota) VALUES ( ?, ?, ?)", 
					nota.getIdFilme(), nota.getIdUsuario(), nota.getNota()
					);
		}
	
	public Boolean jaAvaliou(int idUsu, int idFilme){
		
		String sql = "SELECT CASE WHEN EXISTS ( Select  * from AVALIACAO  as u where u.IDFILME  = ? and u.IDUSUARIO  = ?) THEN CAST(0 AS BIT) ELSE CAST(1 AS BIT) END";

		return jdbcTemplate.queryForObject(sql, Boolean.class, idFilme, idUsu);

		
	
	}
	
	
	
	public List<Nota> mediaAvaliacao(int idFilme){

	
		 
		 
		return jdbcTemplate.query("SELECT AVG(nota) as media FROM AVALIACAO  where IDFILME = ?", new RowMapper<Nota>() {
				
			  public Nota mapRow(ResultSet rs, int rowNum) throws SQLException {

				 Nota notaMedia = new Nota();
				 notaMedia.setNota(rs.getInt("media"));
			    return notaMedia;
			  }
			}, idFilme);
		 


	}
	
	
}
















