package mestreCuca;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceitas {
	
	private List<Receita> livroReceitas = new ArrayList<>();
	private File arquivo;
	
	private String caminho;
	private ObjectMapper mapper = new ObjectMapper();

	public LivroReceitasJson(String caminho, String nome) {
		this.arquivo = new File(caminho+"\\" +nome+".json") ;
		
	
		try {
			this.arquivo.createNewFile();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
			

			
		
		
	System.out.println(arquivo);
		
	}

	@Override
	public void inserir(Receita receita) {
		
		livroReceitas.add(receita);
		
		try {
			 
			// convert user object to json string, and save to a file
			mapper.writeValue(arquivo, livroReceitas);
	 
			// display to console
			System.out.println(mapper.writeValueAsString(livroReceitas));
	 
		}catch (IOException e) {
		
			e.printStackTrace();
		}
		
	 
		
		
	}

	@Override
	public void atualizar(String nome, Receita novaReceita) {
		
		
	}

	@Override
	public void excluir(String nome) {
		
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
	
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		
		return null;
	}

}
