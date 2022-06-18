package datasource.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "fornecedor")
public class Fornecedor {
	
	@Id
	private Long id;
	
	private String nome;
	private String cnpj;
	
	@Column(name = "id_jogo")
	private Long idJogo;
	
	
	
	public Fornecedor(String nome, String cnpj, Long idJogo) {
		this.nome = nome;
		this.cnpj = cnpj;
		this.idJogo = idJogo;
	}
	
	@SuppressWarnings(value = { "unused" })
	public Fornecedor() {
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public Long getId_jogo() {
		return idJogo;
	}
	public void setId_jogo(Long idJogo) {
		this.idJogo = idJogo;
	}
	
	
}
