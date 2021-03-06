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

	public void inserir(Nota nota) {

		if (jaAvaliou(nota.getIdFilme(), nota.getIdUsuario()) == false) {
			jdbcTemplate
					.update("INSERT INTO AVALIACAO (idfilme, idusuario, nota) VALUES ( ?, ?, ?)",
							nota.getIdFilme(), nota.getIdUsuario(),
							nota.getNota());
		} else {
			jdbcTemplate
					.update("UPDATE AVALIACAO SET NOTA = ? WHERE IDFILME =? and IDUSUARIO =?",
							nota.getNota(), nota.getIdFilme(),
							nota.getIdUsuario());

		}

	}

	public boolean jaAvaliou(int idFilme, int idUsu) {

		String sql = "SELECT CASE WHEN EXISTS ( Select  * from AVALIACAO as a  where  a.IDFILME = ? and a.IDUSUARIO = ?) THEN CAST(1 AS BIT) ELSE CAST(0 AS BIT) END";

		return jdbcTemplate.queryForObject(sql, Boolean.class, idFilme, idUsu);

	}

	public List<Nota> mediaAvaliacao(int idFilme) {

		return jdbcTemplate.query(
				"SELECT AVG(nota) as media FROM AVALIACAO  where IDFILME = ?",
				new RowMapper<Nota>() {

					public Nota mapRow(ResultSet rs, int rowNum)
							throws SQLException {

						Nota notaMedia = new Nota();
						notaMedia.setNota(rs.getInt("media"));
						return notaMedia;
					}
				}, idFilme);

	}

	public List<Nota> mediaAvaliacaoGeral() {

		return jdbcTemplate
				.query("SELECT AVG(nota)as media , IDFILME   FROM AVALIACAO group by IDFILME ",
						new RowMapper<Nota>() {

							public Nota mapRow(ResultSet rs, int rowNum)
									throws SQLException {

								Nota notaMedia = new Nota();
								notaMedia.setIdFilme(rs.getInt("IDFILME"));
								notaMedia.setNota(rs.getInt("media"));
								return notaMedia;
							}
						});

	}

}
