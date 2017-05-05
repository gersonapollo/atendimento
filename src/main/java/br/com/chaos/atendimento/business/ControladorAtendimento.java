package br.com.chaos.atendimento.business;

import java.math.BigInteger;
import java.util.LinkedList;

import br.com.chaos.atendimento.model.Senha;
import br.com.chaos.atendimento.model.StatusSenha;
import br.com.chaos.atendimento.repository.SenhaDao;

public class ControladorAtendimento {
	
	public void gerarNovaSenha() {
		SenhaDao senhaDao = new SenhaDao();
		Senha senha;
		LinkedList<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		if(!listaSenhas.isEmpty()) {
			senha = new Senha(listaSenhas.getLast().getNumero().add(BigInteger.ONE), "Aguardando");
		}else {
			senha = new Senha(BigInteger.ZERO, "Aguardando");
		}
		
		senhaDao.adicionarSenha(senha);
	}
	
	public Senha proximaSenha() {
		SenhaDao senhaDao = new SenhaDao();
		LinkedList<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		return listaSenhas.getFirst();
	}
	
	public void atenderSenha() {
		SenhaDao senhaDao = new SenhaDao();
		Senha senha = proximaSenha();
		senhaDao.removerSenha(senha);
	}
	

}
