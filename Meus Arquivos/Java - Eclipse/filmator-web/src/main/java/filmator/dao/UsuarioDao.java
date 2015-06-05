package filmator.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	
	
public void inserir(Usuario usuario){
		
		
		jdbcTemplate.update("INSERT INTO USUARIOS (login, nome, senha) VALUES (?, ?, ?)", 
				usuario.getLogin(), usuario.getNome(), usuario.getSenha());
	}
	
	
public boolean autenticaUsuario(Usuario usuario){
	
	System.out.println(usuario.getLogin());
	System.out.println(usuario.getSenha());
	String sql = "SELECT CASE WHEN EXISTS ( Select  * from USUARIOS as u where u.LOGIN = ? and u.SENHA = ?) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END";

	return jdbcTemplate.queryForObject(sql, Boolean.class, usuario.getLogin(), usuario.getSenha());


}
	

public List<Usuario> buscaUsuario(Usuario usuario){
	
	String filtroNome = usuario.getLogin(); 
	  String filtroSenha = usuario.getSenha();
	
	  autenticaUsuario(usuario);
	  
	 
	return jdbcTemplate.query("Select  id, login, nome, senha, admin from USUARIOS as u where u.LOGIN = ? and u.SENHA = ?", new RowMapper<Usuario>() {
		
		  public Usuario mapRow(ResultSet rs, int rowNum) throws SQLException {
			  Usuario usuarioum = new Usuario();
			  usuarioum.setId(rs.getInt("id"));
			  usuarioum.setLogin(rs.getString("login"));
			  usuarioum.setNome(rs.getString("nome"));
		      usuarioum.setSenha(rs.getString("senha")); 
		      usuarioum.setAdmin(rs.getInt("admin")); 
		    return usuarioum;
		  }
		}, filtroNome, filtroSenha);
	}
	  
		






		



}


