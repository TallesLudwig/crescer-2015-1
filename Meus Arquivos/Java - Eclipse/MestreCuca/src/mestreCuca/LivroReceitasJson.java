package mestreCuca;

import java.io.File;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LivroReceitasJson implements LivroReceitas {
	
	private List<Receita> livroReceitas = new ArrayList<>();
	private File arquivo;
	private ObjectMapper mapper = new ObjectMapper();

	public LivroReceitasJson(String caminho, String nome) {
		this.arquivo = new File(caminho+"\\" +nome+".json") ;
		
	
		try {
			this.arquivo.createNewFile();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}

	@Override
	public void inserir(Receita receita) {
		
		livroReceitas.add(receita);
		escreve();
			
	}

	@Override
	public void atualizar(String nome, Receita novaReceita) {
	
		for (int i = 0; i < livroReceitas.size(); i++) {

			if (livroReceitas.get(i).getNome() == nome) {

				livroReceitas.set(i, novaReceita);
			}
		}
		
		escreve();
		
		
		
	}

	@Override
	public void excluir(String nome) {
		for (int i = 0; i < livroReceitas.size(); i++) {

			if (livroReceitas.get(i).getNome() == nome) {

				livroReceitas.remove(i);
			}
		}
		escreve();
		
	}

	@Override
	public List<Receita> getTodasReceitas() {
	
		return null;
	}

	@Override
	public Receita buscaReceitaPeloNome(String nome) {
		
		return null;
	}

	
	private void escreve(){
		
		try {
			mapper.writeValue(arquivo, livroReceitas); 
		}catch (IOException e) {
		
			e.printStackTrace();
		}
	}
}
