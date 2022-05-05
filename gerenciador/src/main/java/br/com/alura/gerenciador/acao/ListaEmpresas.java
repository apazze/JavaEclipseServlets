package br.com.alura.gerenciador.acao;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.alura.gerenciador.modelo.Banco;
import br.com.alura.gerenciador.modelo.Empresa;

public class ListaEmpresas implements Acao{
	
	
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long antes = System.currentTimeMillis();
		request.setAttribute("inicio", antes);
		
		System.out.println("listando empresa");
		Banco banco = new Banco();
		List<Empresa> lista = banco.getEmpresas();
		request.setAttribute("empresas", lista);
		
		long depois = System.currentTimeMillis();
		request.setAttribute("fim", depois);
		
		
		System.out.println("Tempo de execu��o: [ " + (depois - antes) + " ]");
		
		return "forward:listaEmpresas.jsp";
	}

}
