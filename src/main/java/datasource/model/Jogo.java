package datasource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Jogo {
	
	@Id
	private Long id;
	
	private String nome;
	private String plataforma;
	private String categoria;
	private String preco;
	
	@Column(name = "id_fornecedor")
	private Long idFornecedor;

	public Jogo(Long id, String nome, String plataforma, String categoria, String preco, Long idFornecedor) {
		
		this.id = id;
		this.nome = nome;
		this.plataforma = plataforma;
		this.categoria = categoria;
		this.preco = preco;
		this.idFornecedor = idFornecedor;
	}

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

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Long getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(Long idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	
	
	
}
