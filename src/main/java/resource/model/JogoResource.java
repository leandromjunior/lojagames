package resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JogoResource {
	
	@JsonProperty("nome_jogo")
	private String nome;
	
	@JsonProperty("id_fornecedor")
	private String idFornecedor;
	

	public JogoResource(String nome, String idFornecedor) {
		super();
		this.nome = nome;
		this.idFornecedor = idFornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(String idFornecedor) {
		this.idFornecedor = idFornecedor;
	}
	
	
	
	

}
