package mestreCuca;

import java.util.List;

public interface LivroReceitas {
	
	void inserir(Receita receita);
	void atualizar(String nome, Receita novaReceita);
	void excluir(String nome);
	
	List<Receita> getTodasReceitas();
	
	Receita buscaReceitaPeloNome(String nome);

}
