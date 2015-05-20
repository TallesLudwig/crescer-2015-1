package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;




public class LivroReceita implements LivroReceitas {
	
	
	private List<Receita> LivroReceitas = new ArrayList<>();
	private List<Receita> AlergicosFree = new ArrayList<>();
	
	

	private double valorTotalRecitas ;
	
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
					return LivroReceitas.get(i);				}
				
			}
			
		
				throw new NullPointerException();

	}
	
	public double valorReceitas(List<Receita> receitas){
		
		for (int i = 0;i < receitas.size(); i++){			
			
			valorTotalRecitas += LivroReceitas.get(LivroReceitas.indexOf(receitas.get(i))).getValorTotal();
			
		}
		
		
		return valorTotalRecitas ;
	}
	
	
	 public List<Receita> ProtecaoAlergicos(List<Ingredientes> Ingredientes){
		 
		 	for(int i = 0;i < LivroReceitas.size(); i++){
				
		 		AlergicosFree.add(LivroReceitas.get(i));
		 		
				 for(int a = 0;a < Ingredientes.size(); a++){
					 if(LivroReceitas.get(i).getIngredientes().contains(Ingredientes.get(a))){
						
						 AlergicosFree.remove(LivroReceitas.get(i));
					 
					 }
				 }
				
		
		 	}
			 
			 
				
		
		 return AlergicosFree; 
		 } 
	 
	
	 
	 
	 
	 
	
	 
	 public List<String> listaDeCompras(List<Receita> listaDeCompras){
		
		 
		 Map<String, Double> listaUnidades = new HashMap<>();
		 List<String> novaString =  new ArrayList<>();;
	
	
		 for (Receita receita : listaDeCompras) {
			 for (Ingredientes ingredientes : receita.getIngredientes()) {
				 	String nomeDoIngrediente = ingredientes.getNome();	
					Unidade unidade = ingredientes.getUnidade();
					
					String chaveMap = nomeDoIngrediente + "_" + unidade;
					Double QuantidadeDoIngrediente = ingredientes.getQuantidade();
					
				
					 
					
					 if(!listaUnidades.containsKey(chaveMap)){
						 listaUnidades.put( chaveMap, QuantidadeDoIngrediente);
						
					 }else{
					
						 double novoValor = listaUnidades.get(chaveMap) + QuantidadeDoIngrediente;
						 
						 listaUnidades.put( chaveMap, novoValor);
					 }
			}
		}
		 
			
		for (String receita : listaUnidades.keySet()) {
			
			
			
			
			String splits[]= receita.split("_");
			
	
			 novaString.add(listaUnidades.get(receita)+ " " + splits[1] + " "+ splits[0]);
			//System.out.println(novaString);
			
			
			
		}
		
		
		return novaString;
		
			 
		
	 }
		
	
	 
	 


	
	


}
	


	
	
	
	