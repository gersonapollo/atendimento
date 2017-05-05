package br.com.chaos.atendimento.test;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.chaos.atendimento.business.ControladorAtendimento;
import br.com.chaos.atendimento.model.Senha;
import br.com.chaos.atendimento.model.StatusSenha;
import br.com.chaos.atendimento.repository.SenhaDao;

public class SenhaTest {

	SenhaDao senhaDao = new SenhaDao();
	
	@Test
	public void testaCriacaoListaSenhas() {
		List<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		Assert.assertNotNull(listaSenhas);
	}
	
	@Test
	public void testaCriacaoNovaSenhaComListaVazia() {
		ControladorAtendimento controlador = new ControladorAtendimento();
		controlador.gerarNovaSenha();
		List<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		Assert.assertFalse(listaSenhas.isEmpty());
	}
	
	@Test
	public void testaCriacaoNovaSenhaComListaPreenchida() {
		ControladorAtendimento controlador = new ControladorAtendimento();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		List<Senha> listaSenhas = senhaDao.getListaSenhas(StatusSenha.AGUARDANDO);
		Assert.assertEquals(4, listaSenhas.size());
	}

}
