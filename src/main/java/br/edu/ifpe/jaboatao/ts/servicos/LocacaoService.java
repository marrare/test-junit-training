package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.boDatasIguais;
import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas;

public class LocacaoService {
	
	public Locacao alugarBicicleta(Cliente cliente, Bicicleta bicicleta) {
		Locacao locacao = new Locacao();
		locacao.setBicicleta(bicicleta);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(bicicleta.getValor());
		
		//Definir a entrega para 3 dias depois.
		Date dataEntrega = novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

	public static void main(String[] args) {
		//System.out.println("Funcionando.");
		
		//Cenário
		LocacaoService service = new LocacaoService();
		Cliente cliente = new Cliente("Cliente 01");
		Bicicleta bicicleta = new Bicicleta("Bike 01", 2, 50.0);
		Locacao locacao = new Locacao();
		
		
		//Ação
		locacao = service.alugarBicicleta(cliente, bicicleta);
		
		//Verificação / Validação
		System.out.println(locacao.getValorLocacao());
		System.out.println(boDatasIguais(locacao.getDataLocacao(), new Date()));
		System.out.println(boDatasIguais(locacao.getDataRetorno(), novaDataComDiferencaDeDias(3)));
		
		System.out.println(locacao.getCliente().getNome() == "Cliente 01");
		System.out.println(locacao.getBicicleta().getNome() == "Bike 01");
		System.out.println(locacao.getBicicleta().getEstoque() == 2);

	}
}