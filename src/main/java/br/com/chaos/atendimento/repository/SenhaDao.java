package br.com.chaos.atendimento.repository;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import br.com.chaos.atendimento.model.Senha;
import br.com.chaos.atendimento.model.StatusSenha;

public class SenhaDao {

	private static Map<StatusSenha, LinkedList<Senha>> senhas = new HashMap<>();

	private Map<StatusSenha, LinkedList<Senha>> getSenhas() {
		if (senhas.isEmpty()) {
			senhas.put(StatusSenha.AGUARDANDO, new LinkedList<>());
			senhas.put(StatusSenha.ATENDIDA, new LinkedList<>());
		}
		return this.senhas;
	}

	public void adicionarSenha(Senha senha) {
		this.getSenhas().get(StatusSenha.AGUARDANDO).add(senha);
	}

	public void removerSenha(Senha senha) {
		this.getSenhas().get(StatusSenha.AGUARDANDO).remove(senha);
		this.getSenhas().get(StatusSenha.ATENDIDA).add(senha);
	}
	
	public LinkedList<Senha> getListaSenhas(StatusSenha status){
		return this.getSenhas().get(status);
	}

}
