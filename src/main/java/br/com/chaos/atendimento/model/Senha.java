package br.com.chaos.atendimento.model;

import java.math.BigInteger;

public class Senha {
	
	private BigInteger numero;
	private String Status;
	
	public Senha(BigInteger numero, String status) {
		this.numero = numero;
		Status = status;
	}

	public BigInteger getNumero() {
		return numero;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	

}
