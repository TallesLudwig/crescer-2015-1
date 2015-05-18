package mestreCuca;

import java.util.ArrayList;
import java.util.List;

public class LivroReceita implements LivroReceitas {
	
	
	private List<Receita> LivroReceitas = new ArrayList<>();
	
	public void inserir(Receita receita) {
	
		
		LivroReceitas.add(receita);
		
	}


	public void atualizar(String nome, Receita novaReceita) {
		
		for (int i = 0;i < LivroReceitas.size(); i++){			
			
			if(LivroReceitas.get(i).getNome() == nome ){
				
				LivroReceitas.set(i, novaReceita);
			}	
		}
		
		
	}

	@Override
	public void excluir(String nome) {
		
		for (int i = 0;i < LivroReceitas.size(); i++){			
			
			if(LivroReceitas.get(i).getNome() == nome ){
				
				LivroReceitas.remove(i);
			}	
		}
		
		
	}

	public List<Receita> getTodasReceitas() {
		
		return LivroReceitas;
	}

	
	
	public Receita buscaReceitaPeloNome(String nome){
	
		
			for (int i = 0;i < LivroReceitas.size(); i++){			
				
				if(LivroReceitas.get(i).getNome() == nome ){
					System.out.println(LivroReceitas.get(i));
					return LivroReceitas.get(i);				}
				
			}
			
		
				throw new NullPointerException();
			

				
		
	}


}
	
	
	
	
	
	