package br.com.juan.gerenciador.acao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.juan.gerenciador.modelo.Banco;
import br.com.juan.gerenciador.modelo.Empresa;

public class NovaEmpresaForm implements Acao{
	public String executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		return "forward:formNovaEmpresa.jsp";
	}
}
