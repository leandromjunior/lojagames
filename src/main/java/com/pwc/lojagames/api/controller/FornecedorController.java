package com.pwc.lojagames.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pwc.lojagames.model.Fornecedor;
import com.pwc.lojagames.service.FornecedorService;

@RestController
@RequestMapping(path = "/fornecedor", produces = MediaType.APPLICATION_JSON_VALUE)
public class FornecedorController {
	
	private FornecedorService fornecedorService;

	@Autowired
	public FornecedorController(FornecedorService fornecedorService) {
		this.fornecedorService = fornecedorService;
	}
	
	
	@GetMapping
	public List<Fornecedor> listar() {
		return fornecedorService.listarFornecedor();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Fornecedor> buscar(@PathVariable(name = "id") Long id) {
		return ResponseEntity.ok(fornecedorService.listaporid(id));
	}
	
	@PostMapping
	public ResponseEntity<Fornecedor> salvar(@RequestBody Fornecedor fornecedor) {
		Fornecedor f = fornecedorService.salvarfornecedor(fornecedor);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(f);
	}
}
