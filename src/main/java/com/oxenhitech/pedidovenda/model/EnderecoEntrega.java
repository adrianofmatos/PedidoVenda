package com.oxenhitech.pedidovenda.model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class EnderecoEntrega implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logradouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	
	@NotNull @Size(max=150)
	@Column(name="entrega_logradouro", nullable=false, length=150)
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logadrouro) {
		this.logradouro = logadrouro;
	}

	@NotBlank @Size(max=20)
	@Column(name="entrega_numero", nullable=false, length=20)
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Size(max=150)
	@Column(name="entrega_complemento", length=150)
	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	@NotBlank @Size(max=60)
	@Column(name="entrega_cidade", length=60)
	public String getCidade() {
		return cidade;
	}
	
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	@NotBlank @Size(max=60)
	@Column(name="entrega_uf", nullable=false, length=60)
	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	@NotBlank @Size(max=9)
	@Column(name="entrega_cep", nullable=false, length=9)
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	private String cep;
	
	
}
