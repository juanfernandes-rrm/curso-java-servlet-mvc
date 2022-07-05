package br.com.juan.gerenciador.acao;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.gerenciador.modelo.Banco;
import br.com.juan.gerenciador.modelo.Empresa;

public class NovaEmpresa implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String nomeEmpresa = request.getParameter("nome");
		String paramDataEmpresa = request.getParameter("data");
		
		Date data = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			data = sdf.parse(paramDataEmpresa);
		} catch (ParseException e) {
			throw new ServletException(e);
		}
		
		Empresa empresa = new Empresa();
		empresa.setNome(nomeEmpresa);
		empresa.setDataAbertura(data);
		
		Banco banco = new Banco();
		banco.adiciona(empresa);
		
		System.out.println("Cadastrando nova empresa"+nomeEmpresa);
		
		return "redirect:entrada?acao=ListaEmpresas";
	}
}
