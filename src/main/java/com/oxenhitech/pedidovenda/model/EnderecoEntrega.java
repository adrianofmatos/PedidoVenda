package com.oxenhitech.pedidovenda.model;
import java.io.Serializable;

public class EnderecoEntrega implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String logadrouro;
	private String numero;
	private String complemento;
	private String cidade;
	private String uf;
	public String getLogadrouro() {
		return logadrouro;
	}
	public void setLogadrouro(String logadrouro) {
		this.logadrouro = logadrouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	private String cep;
	
	
}
