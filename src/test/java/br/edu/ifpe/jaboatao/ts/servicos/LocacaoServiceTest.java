package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.boDatasIguais;
import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
	@DisplayName("Teste Estoque zerado - Modo Tradicional")
	public void estoqueVazio() {
		
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bike 01", 0, 50.0));
		
		//Ação
		try {
			service.alugarBicicleta(cliente, bicicletas);
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
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bike 01", 0, 50.0));
		
		//Ação
		Assertions.assertThrows(LocacaoException.class, () ->  {
			service.alugarBicicleta(cliente, bicicletas);
		}, "Não ocorreu a exception estoque vazio");
	}
	
	@Test
	@DisplayName("Teste cliente null - Modo Tradicional")
	public void clienteVazio() {
		
		//Cenário
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bike 01", 0, 50.0));
		
		//Ação
		try {
			service.alugarBicicleta(null, bicicletas);
			Assertions.fail("Não ocorreu a exception cliente vazio");
		} catch (LocacaoException e) {
			Assertions.assertEquals("cliente vazio.", e.getMessage());
		}
	}
	
	@Test
	@DisplayName("Teste cliente null - Modo AssertThrow")
	public void clienteVazio2() {
		
		//Cenário
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bike 01", 0, 50.0));
		
		//Ação
		Assertions.assertThrows(LocacaoException.class, () ->  {
			service.alugarBicicleta(null , bicicletas);
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
			service.alugarBicicleta(cliente, null);
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
		Assertions.assertThrows(LocacaoException.class, () ->  {
			service.alugarBicicleta(cliente , null);
		}, "Não ocorreu a exception bicicleta vazia");
	}
	
	@Test
	@DisplayName("Valor da locacao")
	public void checarValor() {
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bike 01", 1, 40.0), new Bicicleta("Bike 02", 2, 60.0));
		Cliente cliente = new Cliente("Cliente 01");
		Locacao locacao = new Locacao();
		
		try {
			locacao = service.alugarBicicleta(cliente, bicicletas);
		} catch (LocacaoException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		Assertions.assertEquals(100, locacao.getValorLocacao());
	}
	
	@Test
	@DisplayName("Desconto de 10% na sua 2º bike.")
	public void desconto01() throws LocacaoException {
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bicicleta 01", 2, 40.0), new Bicicleta("Bicicleta 02", 2, 40.0));
		
		//Ação
		Locacao locacao = service.alugarBicicleta(cliente, bicicletas);
		
		//Verificação
		Assertions.assertEquals(76, locacao.getValorLocacao());
		
	}
	
	@Test//
	@DisplayName("Desconto de 15% na sua 3º bike.")
	public void desconto02() throws LocacaoException {
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bicicleta 01", 2, 40.0), new Bicicleta("Bicicleta 02", 2, 40.0), new Bicicleta("Bicicleta 03", 2, 40.0));
		
		//Ação
		Locacao locacao = service.alugarBicicleta(cliente, bicicletas);
		
		//Verificação
		Assertions.assertEquals(110, locacao.getValorLocacao());
		
	}
	
	@Test//
	@DisplayName("Desconto de 25% na sua 4º bike.")
	public void desconto03() throws LocacaoException {
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bicicleta 01", 2, 40.0), new Bicicleta("Bicicleta 02", 2, 40.0), new Bicicleta("Bicicleta 03", 2, 40.0), new Bicicleta("Bicicleta 04", 2, 40.0));
		
		//Ação
		Locacao locacao = service.alugarBicicleta(cliente, bicicletas);
		
		//Verificação
		Assertions.assertEquals(140, locacao.getValorLocacao());
		
	}
	
	@Test//
	@DisplayName("Desconto de 50% na sua 5º bike.")
	public void desconto04() throws LocacaoException {
		//Cenário
		Cliente cliente = new Cliente("Cliente 01");
		List<Bicicleta> bicicletas = Arrays.asList(new Bicicleta("Bicicleta 01", 2, 40.0), new Bicicleta("Bicicleta 02", 2, 40.0), new Bicicleta("Bicicleta 03", 2, 40.0), new Bicicleta("Bicicleta 04", 2, 40.0), new Bicicleta("Bicicleta 05", 2, 40.0));
		
		//Ação
		Locacao locacao = service.alugarBicicleta(cliente, bicicletas);
		
		//Verificação
		Assertions.assertEquals(160, locacao.getValorLocacao());
		
	}
}
