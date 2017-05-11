package br.com.chaos.atendimento.test;

import java.util.ArrayList;
import java.util.LinkedList;
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
		ControladorAtendimento controlador = new ControladorAtendimento();
		LinkedList<Senha> listaAguardando = controlador.getListaAguardando();
		LinkedList<Senha> listaAtendidas = controlador.getListaAtendidas();
		Assert.assertNotNull(listaAguardando);
		Assert.assertNotNull(listaAtendidas);
	}
	
	@Test
	public void testaCriacaoNovaSenhaComListaVazia() {
		ControladorAtendimento controlador = new ControladorAtendimento();
		controlador.gerarNovaSenha();
		List<Senha> listaSenhas = controlador.getListaAguardando();
		Assert.assertFalse(listaSenhas.isEmpty());
	}
	
	@Test
	public void testaCriacaoNovaSenhaComListaPreenchida() {
		ControladorAtendimento controlador = new ControladorAtendimento();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		List<Senha> listaSenhas = controlador.getListaAguardando();
		Assert.assertEquals(3, listaSenhas.size());
	}
	
	@Test
	public void testaAtendimentoSenha() {
		ControladorAtendimento controlador = new ControladorAtendimento();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		controlador.gerarNovaSenha();
		LinkedList<Senha> listaAguardando = controlador.getListaAguardando();
		LinkedList<Senha> listaAtendidas = controlador.getListaAtendidas();
		Assert.assertEquals(3, listaAguardando.size());
		Assert.assertEquals(0, listaAtendidas.size());
		controlador.atenderProximaSenha();
		Assert.assertEquals(2, listaAguardando.size());
		Assert.assertEquals(1, listaAtendidas.size());
		
	}

}
