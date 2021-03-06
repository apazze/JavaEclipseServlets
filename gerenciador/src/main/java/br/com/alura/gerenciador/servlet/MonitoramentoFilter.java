package br.com.alura.gerenciador.servlet;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/entrada")
public class MonitoramentoFilter implements Filter {
	
	@Override
	public void init(FilterConfig config) throws ServletException {}
	
	@Override
	public void destroy() {}
	
	//Filtros s?o executados antes do controller e ap?s, similar a uma porta girat?ria, posso continuar a execu??o ou barrar

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		System.out.println("MonitoramentoFilter");
		long antes = System.currentTimeMillis();
		
		String acao = request.getParameter("acao");
		
		//executa a a??o (semelhante ao forward, continue a execu??o)
		chain.doFilter(request, response);
		
		long depois = System.currentTimeMillis();
		System.out.println("Tempo de execucao da acao [ " + acao + " ] => " + (depois - antes));
		
		
	}

}
