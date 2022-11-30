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
import com.devti.aula.services.CidadeService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {
	
	@Autowired
	CidadeService service;
	
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Exclui uma cidade da base de dados")
	public void excluir(@PathVariable("id") int id) {
		service.excluir(id);
	}
	
	@PutMapping
	@ApiOperation(value = "Alterar uma cidade na base dados")
	public Cidade altera(@RequestBody Cidade c) {		
		return service.alterar(c);
		
	}
	
	@PostMapping
	@ApiOperation(value = "Inserir uma cidade no banco de dados")
	public Cidade inserirCidade(@RequestBody Cidade c) {
		return service.incluir(c);
		
	}
	
	@GetMapping
	@ApiOperation(value = "Listar todas as cidades da base de dados")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Lista de Cidades")
	})
	public List<Cidade> listarTodas(){
		return service.listarTodas();
	}
	
	@GetMapping("/buscauf/{uf}")
	@ApiOperation(value = "Busca uma cidade por UF")
	public List<Cidade> buscarPorUf(@PathVariable("uf") String uf){
		return service.buscarPorUf(uf);
	}

}
