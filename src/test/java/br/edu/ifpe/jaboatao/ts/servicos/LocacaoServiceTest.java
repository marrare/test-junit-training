package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.boDatasIguais;
import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;

public class LocacaoServiceTest {

	@Test
	public void primeiroTeste() {
		
		//Cenário
		LocacaoService service = new LocacaoService();
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
}
