package filmator.dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import filmator.model.Filme;
import filmator.model.Genero;

@Component
public class FilmeDao {

	
	@Inject
	private JdbcTemplate jdbcTemplate;
	

	public void inserir(Filme filme){
		
		
		jdbcTemplate.update("INSERT INTO Filme (nome, ano, genero, sinopse, imagem) VALUES (?, ?, ?, ?, ?)", 
		filme.getNome(), filme.getAno(), filme.getGenero().name(), filme.getSinopse(), filme.getImagem());
	}
	
	
	
	public List<Filme> buscaTodosFilmesJava8(){
		
		List<Filme> a= new ArrayList<>();
		
		
		return a = jdbcTemplate.query("SELECT nome, ano, genero, sinopse, imagem FROM Filme", new RowMapper<Filme>(){
			
			
				
			public Filme mapRow(ResultSet rs, int row) throws SQLException {
				
				
				
				Filme filme = new Filme();
				filme.setNome(rs.getString("nome"));
				filme.setAno(rs.getInt("ano"));
				filme.setGenero(Genero.valueOf(rs.getString("genero")));
				filme.setSinopse(rs.getString("sinopse"));
				filme.setImagem(rs.getString("imagem"));
			
			
				return filme;
				
				
			};
			
			
		});
		
	}
	
//	public static void main(String[] args) {
//		
//		System.out.println(Genero.FICCAO_CIENTIFICA.name());
//	}
	
}
