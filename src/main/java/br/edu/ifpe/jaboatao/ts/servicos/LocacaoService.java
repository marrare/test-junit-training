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
		Date dataEntrega = ManipulandoDatas.novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		
		//Salvando a locacao...	
		//O método salvar() será implementado com o avançar do curso.

		return locacao;
	}

	public static void main(String[] args) {
		System.out.println("Funcionando.");

	}
}