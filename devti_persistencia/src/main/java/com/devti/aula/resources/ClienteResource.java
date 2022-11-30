package com.devti.aula.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.devti.aula.model.Cidade;
import com.devti.aula.model.Cliente;
import com.devti.aula.services.ClienteService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cliente")
public class ClienteResource {
	
	@Autowired
	ClienteService service;
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui uma cliente da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
	
	@PutMapping
	@ApiOperation(value = "Altera um cliente da base de dados")
	public Cliente altera(@RequestBody Cliente e ){	
		return service.alterar(e);
		
	}
	
	@PostMapping
	@ApiOperation(value = "Inserir um cliente na base dados")
	public Cliente inserirCliente(@RequestBody Cliente e) {
		return service.incluir(e);
		
	}
	
	
	@GetMapping
	@ApiOperation(value = "Lista todos os clientes da base de dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de Clientes")
	})
	public List<Cliente> listarTodos(){
		return service.listarTodos();
		
	}
	
	@GetMapping("/buscacidade/{cidade}")
	@ApiOperation(value = "Busca um cliente por Cidade")
	public List<Cliente> buscarPorID(@PathVariable("cidade") Cidade c){
		return service.buscarPorID(c);
	}
	
	@GetMapping("/buscanome/{cidade}")
	@ApiOperation(value = "Busca um cliente por Cidade")
	public List<Cliente> buscarCidade(@PathVariable("cidade") String nome){
		return service.buscarCidade(nome);
	}	
	 

}
