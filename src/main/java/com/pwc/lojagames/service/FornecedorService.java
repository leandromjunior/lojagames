package com.pwc.lojagames.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
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
	
	//POST
	public Fornecedor salvarfornecedor(Fornecedor fornece) {
		fornece.getJogo().forEach(j -> j.setFornecedor(fornece));
		return fornecedorRepository.save(fornece);
	}
	
	//PUT
	public Fornecedor atualizarFornecedor(Long id, Fornecedor fornece) {
		Fornecedor fornecedorSalvo = findOrFail(id);
		fornecedorSalvo.getJogo().clear();
		fornecedorSalvo.getJogo().addAll(fornece.getJogo());
		
		BeanUtils.copyProperties(fornece, fornecedorSalvo, "id", "jogo"); //Copia as propriedades de fornecedor, menos id e jogo que já foram tratados acima
		
		return fornecedorRepository.save(fornecedorSalvo);
	}
	
	//DELETE
	public void deletarFornecedor(Long id) {
		Fornecedor f = findOrFail(id); 
		fornecedorRepository.delete(f);
	}
	
	private Fornecedor findOrFail(Long id) {
		return fornecedorRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Fornecedor não encontrado"));
	}
	

}
