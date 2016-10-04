package br.com.icamy.testes;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.icamy.beans.Prestador;
import br.com.icamy.dao.PrestadorDAO;
import br.com.icamy.factory.ConnectionFactory;

public class TesteBeans {

	public static void main(String[] args) {
		
//		try {
//			OfertaBO oBO = new OfertaBO();
//			List<Oferta> ofertasPrestador = oBO.getByPrestador(3);
//			for (Oferta oferta : ofertasPrestador) {
//				System.out.println("Código: " + oferta.getCodigo());
//				System.out.println("Título: " + oferta.getTitulo());
//				System.out.println("//---------------//");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

		try {
			Prestador p = new PrestadorDAO().get(1);
			System.out.println(p.getNome());
		} catch (Exception e) {
			e.printStackTrace();
		}


	}

}
