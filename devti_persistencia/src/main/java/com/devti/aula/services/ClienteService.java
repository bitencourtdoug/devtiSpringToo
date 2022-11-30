package com.devti.aula.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository rep;	
	
	
	public List<Cliente> buscarPorID(Cidade c){
		return rep.findByCidade(c);
	}
	
	public List<Cliente> buscarCidade(String nome){
		return rep.findByCidadeNome(nome);
	}

		 
	
	public void excluir(Integer id) {
		Cliente clienteExcluir = rep.findById(id).get();
		if(clienteExcluir != null) {
			rep.delete(clienteExcluir);
		}
	}
	
	public Cliente incluir(Cliente e) {
		return rep.save(e);
	}
	
	public List<Cliente> listarTodos(){
		return rep.findAll();
	}
	
	public Cliente alterar(Cliente e) {
		return rep.save(e);
	}

}
