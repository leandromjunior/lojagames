package com.pwc.lojagames.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pwc.lojagames.exception.EntidadeNaoEncontradaException;
import com.pwc.lojagames.model.Fornecedor;
import com.pwc.lojagames.repository.FornecedorRepository;

@Service
public class FornecedorService {
	
	private FornecedorRepository fornecedorRepository; //Essencial para a camada de serviço acessar o repositório da camada de dados

	//Injetando dependência
	@Autowired
	public FornecedorService(FornecedorRepository fornecedorRepository) {
		this.fornecedorRepository = fornecedorRepository;
	}
	
	//GET
	public List<Fornecedor> listarFornecedor() {
		return fornecedorRepository.findAll();
	}
	
	//GET By ID
	public Fornecedor listaporid(Long id) {
		return findOrFail(id);
	}
	
	private Fornecedor findOrFail(Long id) {
		return fornecedorRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado"));
	}
	

}
