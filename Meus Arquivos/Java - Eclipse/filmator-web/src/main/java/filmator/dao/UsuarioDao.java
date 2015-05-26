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
import filmator.model.Usuario;


@Component
public class UsuarioDao {
	
	
	@Inject
	private JdbcTemplate jdbcTemplate;
	
	
public int autentica(Usuario usuario){
		
	String sql = "SELECT CASE WHEN EXISTS ( Select  * from USUARIO as u where u.NOME = ? and u.SENHA = ?) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END";
	 
	Customer customer = (Customer)getJdbcTemplate().queryForObject(
			sql, new Object[] { custId }, new CustomerRowMapper());
	
		return jdbcTemplate.query("SELECT CASE WHEN EXISTS ( Select  * from USUARIO as u where u.NOME = ? and u.SENHA = ?) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END", 
				 usuario.getNome(), usuario.getSenha());
	}



}


