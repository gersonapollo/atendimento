package br.com.chaos.atendimento.business;

import java.math.BigInteger;
import java.util.LinkedList;

import br.com.chaos.atendimento.model.Senha;
import br.com.chaos.atendimento.model.StatusSenha;
import br.com.chaos.atendimento.repository.SenhaDao;

public class ControladorAtendimento {
	
	public ControladorAtendimento() {
		senhaDao = new SenhaDao();
	}
	
	private SenhaDao senhaDao;
	
	public LinkedList<Senha> getListaAguardando() {
		return senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
	}
	
	public LinkedList<Senha> getListaAtendidas() {
		return senhaDao.getListaSenhas(StatusSenha.ATENDIDA);
	}
	
	public void gerarNovaSenha() {
		Senha senha;
		LinkedList<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		if(!listaSenhas.isEmpty()) {
			senha = new Senha(listaSenhas.getLast().getNumero().add(BigInteger.ONE), "Aguardando");
		}else {
			senha = new Senha(BigInteger.ZERO, "Aguardando");
		}
		
		senhaDao.adicionarSenha(senha);
	}
	
	public void atenderProximaSenha() {
		Senha senha = proximaSenha();
		senhaDao.removerSenha(senha);
	}
	
	public Senha proximaSenha() {
		LinkedList<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		return listaSenhas.getFirst();
	}
	
	

}
