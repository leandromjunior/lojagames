package com.pwc.lojagames.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.lojagames.model.Fornecedor;
import com.pwc.lojagames.service.FornecedorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping(path = "/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
public class FornecedorController {
	
	private FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}
	
	@ApiOperation("Listar todos os fornecedores")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de fornecedores"),
		    @ApiResponse(code = 500, message = "Foi gerado um erro ao listar todos os fornecedores")
		})
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorService.listarFornecedor();
	}
	
	@ApiOperation("Listar fornecedor por ID")
	@ApiResponses(value = {
		    @ApiResponse(code = 200, message = "Retorna a lista de fornecedor por ID"),
		    @ApiResponse(code = 500, message = "Foi gerado um erro ao listar fornecedor")
		})
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscar(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(fornecedorService.listaporid(id));
	}
	
	@ApiOperation("Inserir fornecedores")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Insere um fornecedor"),
			@ApiResponse(code = 500, message = "Foi gerado um erro ao inserir fornecedor")
	})
	@PostMapping
	public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor) {
		Fornecedor f = fornecedorService.salvarfornecedor(fornecedor);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(f);
	}
	
	@ApiOperation("Atualizar fornecedor por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Atualiza um fornecedor"),
			@ApiResponse(code = 500, message = "Foi gerado um erro ao atualizar fornecedor")
	})
	@PutMapping("/{id}")
	public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
		return ResponseEntity.ok(fornecedorService.atualizarFornecedor(id, fornecedor));
	}
	
	@ApiOperation("Deletar fornecedor por ID")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Deleta um fornecedor"),
			@ApiResponse(code = 500, message = "Foi gerado um erro ao deletar fornecedor")
	})
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletarFornecedor(@PathVariable Long id) {
		fornecedorService.deletarFornecedor(id);
	}
}
