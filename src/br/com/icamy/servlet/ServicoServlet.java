package br.com.icamy.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.icamy.beans.Servico;
import br.com.icamy.bo.ServicoBO;

@WebServlet("/Servico")
public class ServicoServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        try {
            ServicoBO servicoBO = new ServicoBO();
            Servico servico = servicoBO.get(Integer.parseInt(request.getParameter("codigo")));
            
            out.println("Servico");
            out.println("Código: " + servico.getCodigo());
            out.println("Nome: " + servico.getNome());
            out.println("Descrição: " + servico.getNome());
            out.println("Status: " + servico.getStatus());
        } catch(Exception e) {
            out.println(e.getMessage());
            System.out.println("Erro: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}
