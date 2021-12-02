package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.boDatasIguais;
import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.exception.LocacaoException;

@TestMethodOrder(MethodOrderer.Random.class)
public class LocacaoServiceTest {
	LocacaoService service;
	
	@BeforeEach()
	public void executaAntes() {
		this.service = new LocacaoService(); 
	}

	@Test
	@Disabled
	public void primeiroTeste() throws LocacaoException {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bicicleta = new Bicicleta("Bike 01", 2, 50.0);
		Locacao locacao = new Locacao();
		
		
		//Ação
		locacao = service.alugarBicicleta(cliente, bicicleta);
		
		//Verificação / Validação
		Assertions.assertTrue(locacao.getValorLocacao() == 50);
		Assertions.assertTrue(boDatasIguais(locacao.getDataLocacao(), new Date()));
		Assertions.assertTrue(boDatasIguais(locacao.getDataRetorno(), novaDataComDiferencaDeDias(3)));
		Assertions.assertTrue(locacao.getCliente().getNome() == "Cliente 01");
		Assertions.assertTrue(locacao.getBicicleta().getNome() == "Bike 01");
		Assertions.assertTrue(locacao.getBicicleta().getEstoque() == 2);
		
	}
	
	@Test
	@DisplayName("Teste Estoque zerado - Modo Tradicional")
	public void estoqueVazio() {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bicicleta = new Bicicleta("Bike 01", 0, 50.0);
		Locacao locacao = new Locacao();
		
		//Ação
		try {
			locacao = service.alugarBicicleta(cliente, bicicleta);
			Assertions.fail("Não ocorreu a exception estoque vazio.");
		} catch (LocacaoException e) {
			Assertions.assertEquals("Bicicleta sem estoque.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Teste Estoque zerado - Modo AssertThrow")
	public void estoqueVazio2() {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bicicleta = new Bicicleta("Bike 01", 0, 50.0);
		
		//Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->  {
			Locacao locacao = service.alugarBicicleta(cliente, bicicleta);
		}, "Não ocorreu a exception estoque vazio");
	}
	
	@Test
	@DisplayName("Teste cliente null - Modo Tradicional")
	public void clienteVazio() {
		
		//Cenário
		Bicicleta bicicleta = new Bicicleta("Bike 01", 2, 50.0);
		Locacao locacao = new Locacao();
		
		//Ação
		try {
			locacao = service.alugarBicicleta(null, bicicleta);
			Assertions.fail("Não ocorreu a exception cliente vazio");
		} catch (LocacaoException e) {
			Assertions.assertEquals("cliente vazio.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Teste cliente null - Modo AssertThrow")
	public void clienteVazio2() {
		
		//Cenário
		Bicicleta bicicleta = new Bicicleta("Bike 01", 2, 50.0);
		
		//Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->  {
			Locacao locacao = service.alugarBicicleta(null , bicicleta);
		}, "Não ocorreu a exception cliente vazio");
	}
	
	@Test
	@DisplayName("Teste bicicleta null - Modo Tradicional")
	public void bicicletaVazia() {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		Locacao locacao = new Locacao();
		
		//Ação
		try {
			locacao = service.alugarBicicleta(cliente, null);
			Assertions.fail("Não ocorreu a exception bicicleta vazia");
		} catch (LocacaoException e) {
			Assertions.assertEquals("bicicleta vazia.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Teste bicicleta null - Modo AssertThrow")
	public void bicicletaVazia2() {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		
		//Ação
		LocacaoException e = Assertions.assertThrows(LocacaoException.class, () ->  {
			Locacao locacao = service.alugarBicicleta(cliente , null);
		}, "Não ocorreu a exception bicicleta vazia");
	}
}
