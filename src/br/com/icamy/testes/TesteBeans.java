package br.com.icamy.testes;

import br.com.icamy.beans.CategoriaServico;
import br.com.icamy.beans.Servico;

public class TesteBeans {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Servico s = new Servico(1, new CategoriaServico(1, "Corte Feminino"), "Corte da moda", 1, 
				"Este é o verdadeiro corte da moda atual!");
		
		System.out.println(s.getCodigo());
		System.out.println(s.getCategoriaServico().getNome());
		System.out.println(s.getNome());
		System.out.println(s.getDescricao());

	}

}
