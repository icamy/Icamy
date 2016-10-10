package br.com.icamy.pgto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class IntegraPagSeguro {
	private String urlPrefixo;
	private String email;
	private String token;
	private String url;
	
	public IntegraPagSeguro(String cdPgto) {
		this.urlPrefixo = "https://ws.sandbox.pagseguro.uol.com.br/v3/transactions/";
		this.email = "icamy.contato@gmail.com";
		this.token = "3627AC1B19C24EF3A2706BD84CC7D412";
		this.url = urlPrefixo + cdPgto + "?email=" + email + "&token=" + token;
	}
	
	public String retornaUrl() {
		return this.url;
	}
	
	public String getXML() {
		String xml = "";
		try {
			URL url = new URL(this.url);
	        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
	        BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
	 
	        String line = null;
	        
	        while( (line = in.readLine()) != null ){
	        	xml += line;
	        }
	 
	 		in.close();
	        urlConnection.disconnect();
	        
	      } catch (MalformedURLException e){
	         System.out.println("Erro ao criar URL. Formato inválido.");
	         System.exit(1);
	      } catch (IOException e2) {
	         System.out.println("Erro ao acessar URL.");
	         System.exit(1);
	      } catch (Exception e) {
	    	  System.out.println("Erro desconehcido");
	      }
		return xml;
	}
	
	public Map<String, String> parseXML(String xml) throws ParserConfigurationException, SAXException, IOException {
	    InputSource is = new InputSource(new StringReader(xml));
	    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	    Document doc = dBuilder.parse(is);
	    
	    Map<String, String> resultado = new HashMap<String, String>();

	    doc.getDocumentElement().normalize();
	    resultado.put("data", doc.getElementsByTagName("date").item(0).getTextContent());
	    resultado.put("cdPgto", doc.getElementsByTagName("code").item(0).getTextContent());
	    resultado.put("referencia", doc.getElementsByTagName("reference").item(0).getTextContent());
	    resultado.put("valor", doc.getElementsByTagName("grossAmount").item(0).getTextContent());
	    resultado.put("cdOferta", doc.getElementsByTagName("id").item(0).getTextContent());
	    String descricao = doc.getElementsByTagName("description").item(0).getTextContent();
	    String[] detalhes = descricao.split(" - ");
	    resultado.put("descricao", descricao);
	    resultado.put("prestador", detalhes[0]);
	    resultado.put("servico", detalhes[1]);
	    //resultado.put("cliente", doc.getElementsByTagName("name").item(0).getTextContent());
	    //resultado.put("email", doc.getElementsByTagName("email").item(0).getTextContent());
	    
	    return resultado;
	}

}
