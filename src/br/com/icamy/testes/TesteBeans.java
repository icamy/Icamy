package br.com.icamy.testes;

import java.util.List;

import br.com.icamy.beans.Bairro;
import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.BairroDAO;
import br.com.icamy.dao.PrestadorDAO;

public class TesteBeans {

	public static void main(String[] args) {
		
		try {
			List<Prestador> lstPrestadores = new PrestadorDAO().selectAll();
			for (Prestador p : lstPrestadores) {
//				p.setBairro(new BairroDAO().selectWherePrestador(p));
//				for (Bairro b : p.getBairro()) {
//					System.out.println(b.getNome());
//				}
				System.out.println("Código: " + p.getCodigo());
				System.out.println("Nome: " + p.getNome());
				System.out.println("Bairros: ");
				for (Bairro b : p.getBairro()) {
					System.out.println("- " + b.getNome() + "(" + b.getRegiao() + ")");
				}
				System.out.println("//---------------//");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


}
