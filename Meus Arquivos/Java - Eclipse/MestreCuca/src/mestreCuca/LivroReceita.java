package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;



public class LivroReceita implements LivroReceitas {
	
	
	private List<Receita> LivroReceitas = new ArrayList<>();
	private List<Receita> AlergicosFree = new ArrayList<>();
	
	private Map<Unidade, Map<String, Double>> Lista = new HashMap<>();

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
	 
	
	 
	 
	 
	 
	 // métodos devem iniciar com letra minuscula; nomes de parametro também
	 
	 public Map<String, Double> listaDeCompras(List<Receita> listaDeCompras){
		 // variaveis com letra minuscula
		 
		 Map<String, Double> listaUnidades = new HashMap<>();
		 
		 // substituir for por for each
	
	
		for(int i = 0;i < listaDeCompras.size(); i++){
    		// substituir for por for each
			 for (int j = 0; j <listaDeCompras.get(i).getIngredientes().size(); j++) {
				
				//Unidade UnidadeDoIngrediente = ListaDeCompras.get(i).getIngredientes().get(j).getUnidade();				 				
				
				String nomeDoIngrediente = listaDeCompras.get(i).getIngredientes().get(j).getNome();	
				Unidade unidade = listaDeCompras.get(i).getIngredientes().get(j).getUnidade();
				
				String chaveMap = nomeDoIngrediente + "_" + unidade;
				Double QuantidadeDoIngrediente = listaDeCompras.get(i).getIngredientes().get(j).getQuantidade();
				
			
				 
				
				 if(!listaUnidades.containsKey(chaveMap)){
					 listaUnidades.put( chaveMap, QuantidadeDoIngrediente);
					
				 }else{
				
					 double novoValor = listaUnidades.get(chaveMap) + QuantidadeDoIngrediente;
					 
					 listaUnidades.put( chaveMap, novoValor);
				 }
			
			 }
				 	
			
				// indentação (tabs, e espaçamentos)
		 }
			 
			
			 System.out.println(listaUnidades);
			 System.out.println(Lista);
			 return listaUnidades;
		
	 }
		
	
	 
	 
	 
	 @Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	
	


}
	
	
	
	
	
	