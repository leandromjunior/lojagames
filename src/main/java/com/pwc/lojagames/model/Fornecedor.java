package com.pwc.lojagames.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModelProperty;



@Entity
public class Fornecedor {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Column(nullable = false, length=70)
	@ApiModelProperty(value = "Nome do fornecedor não pode ser vazio")
	private String nome;
	
	@NotBlank
	@Column(nullable = false, length=70)
	@ApiModelProperty(value = "Avaliação do fornecedor não pode ser vazio")
	private Float avaliacao;
	
	@NotBlank
	@Column(nullable = false, length=70)
	@ApiModelProperty(value = "Código do fornecedor não pode ser vazio")
	private Integer codigo;
	
	@JsonIgnoreProperties("fornecedor")
	@OneToMany(mappedBy = "fornecedor", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Jogo> jogo = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Float avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public List<Jogo> getJogo() {
		return jogo;
	}

	public void setJogo(List<Jogo> jogo) {
		this.jogo = jogo;
	}

	

}
