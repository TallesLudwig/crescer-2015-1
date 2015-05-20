package mestreCuca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Livro implements LivroReceitas {

	private List<Receita> livroReceitas = new ArrayList<>();

	private double valorTotalRecitas;

	public void inserir(Receita receita) {

		livroReceitas.add(receita);

	}

	public void atualizar(String nome, Receita novaReceita) {

		for (int i = 0; i < livroReceitas.size(); i++) {

			if (livroReceitas.get(i).getNome() == nome) {

				livroReceitas.set(i, novaReceita);
			}
		}

	}

	public void excluir(String nome) {

		for (int i = 0; i < livroReceitas.size(); i++) {

			if (livroReceitas.get(i).getNome() == nome) {

				livroReceitas.remove(i);
			}
		}

	}

	public List<Receita> getTodasReceitas() {

		return livroReceitas;
	}

	public Receita buscaReceitaPeloNome(String nome) {

		for (int i = 0; i < livroReceitas.size(); i++) {

			if (livroReceitas.get(i).getNome() == nome) {
				return livroReceitas.get(i);
			}

		}

		throw new NullPointerException();

	}

	public double valorReceitas(List<Receita> receitas) {

		for (int i = 0; i < receitas.size(); i++) {

			valorTotalRecitas += livroReceitas.get(
					livroReceitas.indexOf(receitas.get(i))).getValorTotal();

		}

		return valorTotalRecitas;
	}

	public List<Receita> ProtecaoAlergicos(List<Ingredientes> ingredientes) {
		List<Receita> alergicosFree = new ArrayList<>();

		for (Receita receita : livroReceitas) {
			alergicosFree.add(receita);
			for (Ingredientes ingr : ingredientes) {
				if (receita.getIngredientes().contains(ingr)) {

					alergicosFree.remove(receita);

				}
			}
		}

		return alergicosFree;
	}

	public List<String> listaDeCompras(List<Receita> listaDeCompras) {

		Map<String, Double> listaUnidades = new HashMap<>();
		List<String> novaString = new ArrayList<>();

		for (Receita receita : listaDeCompras) {
			for (Ingredientes ingredientes : receita.getIngredientes()) {
				String nomeDoIngrediente = ingredientes.getNome();
				Unidade unidade = ingredientes.getUnidade();

				String chaveMap = nomeDoIngrediente + "_" + unidade;
				Double QuantidadeDoIngrediente = ingredientes.getQuantidade();

				if (!listaUnidades.containsKey(chaveMap)) {
					listaUnidades.put(chaveMap, QuantidadeDoIngrediente);
				} else {
					double novoValor = listaUnidades.get(chaveMap)+QuantidadeDoIngrediente;
					listaUnidades.put(chaveMap, novoValor);
				}
			}
		}

		for (String receita : listaUnidades.keySet()) {

			String splits[] = receita.split("_");

			novaString.add(listaUnidades.get(receita) + " " + splits[1] + " "
					+ splits[0]);

		}

		System.out.println(novaString + "\n");
		return novaString;

	}

}
