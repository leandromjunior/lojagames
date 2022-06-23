package com.pwc.lojagames.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.EqualsAndHashCode;

@Entity //é uma entidade do BD
public class Jogo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer cod;
	
	@Column(length=70)
	private String nome;
	
	@Column(length=50)
	private String plataforma;
	
	@Column(length=50)
	private String categoria;
	
	@Column(length=10)
	private Float preco;
	
	
	
	@ManyToOne //Pode ter vários jogos para um fornecedor
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	public Integer getCod() {
		return cod;
	}



	public void setCod(Integer cod) {
		this.cod = cod;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public String getPlataforma() {
		return plataforma;
	}



	public void setPlataforma(String plataforma) {
		this.plataforma = plataforma;
	}



	public String getCategoria() {
		return categoria;
	}



	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}



	public Float getPreco() {
		return preco;
	}



	public void setPreco(Float preco) {
		this.preco = preco;
	}



	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}



	
	
	
}
