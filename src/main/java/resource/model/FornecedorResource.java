package resource.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FornecedorResource {
	
	@JsonProperty("nome_fornecedor")
	private String Nome;
	
	@JsonProperty("id_jogo")
	private String idJogo;
	
	
	
	public FornecedorResource(String nome, String idJogo) {

		Nome = nome;
		this.idJogo = idJogo;
	}
	
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public String getIdJogo() {
		return idJogo;
	}
	public void setIdJogo(String idJogo) {
		this.idJogo = idJogo;
	}
	
	

}
