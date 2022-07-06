package br.com.juan.gerenciador.modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

public class Banco {

	private static List<Empresa> lista = new ArrayList<>();
	private static List<Usuario> listaUsuario = new ArrayList<>();
	private static Integer chaveSequencial =1;
	
	//bloco estático, executa quando inicia a classe
	static {
		Empresa empresa = new Empresa();
		empresa.setId(chaveSequencial++);
		empresa.setNome("Alura");
		
		Empresa empresa2 = new Empresa();
		empresa2.setId(chaveSequencial++);
		empresa2.setNome("Caelum");
		
		Empresa empresa3 = new Empresa();
		empresa3.setId(chaveSequencial++);
		empresa3.setNome("Teste");
		lista.add(empresa);
		lista.add(empresa2);
		lista.add(empresa3);
		
		Usuario u1 = new Usuario();
		u1.setLogin("Nico");
		u1.setSenha("12345");
		Usuario u2 = new Usuario();
		u2.setLogin("Juan");
		u2.setSenha("12345");
		
		listaUsuario.add(u1);
		listaUsuario.add(u2);
	}
	
	public void adiciona(Empresa empresa) {
		// TODO Auto-generated method stub
		empresa.setId(Banco.chaveSequencial++);
		Banco.lista.add(empresa);
	}

	
	public List<Empresa> getEmpresas(){
		return Banco.lista;
	}


	public void removeEmpresa(Integer id) {
		Iterator<Empresa> it = lista.iterator();
		
		while(it.hasNext()) {
			Empresa emp = it.next();
			if(emp.getId() == id) {
				it.remove();
			}
		}
		
		//Não funciona. Não da para iterar um lista e modificá-la ao mesmo tempo com for each		
//		for ( Empresa empresa : lista) {
//			if(empresa.getId() == id) {
//				lista.remove(empresa);
//			}
//		}
		
	}


	public Empresa buscaEmpresaPelaId(Integer id) {
		for (Empresa empresa : lista) {
			if(empresa.getId() == id) {
				return empresa;
			}
		}
		return null;
	}


	public Usuario existeUsuario(String login, String senha) {
		for(Usuario usuario:listaUsuario) {
			if(usuario.ehIgual(login, senha)) {
				return usuario;
			}
		}
		return null;
	}
}
