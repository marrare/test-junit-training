package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.exception.LocacaoException;

public class LocacaoService {
	private int varPublica;
	private int varPrivate;
	protected int varProtegida;
	int varDefault;
	
	public Locacao alugarBicicleta(Cliente cliente, List<Bicicleta> bicicletas) throws LocacaoException {
		
		Double precoBicicletas = 0.0;
		
		if (bicicletas == null) throw new LocacaoException("bicicleta vazia.");
		if (cliente == null) throw new LocacaoException("cliente vazio.");
		for( Bicicleta bicicleta: bicicletas ) {
			if (bicicleta.getEstoque() == 0) throw new LocacaoException("Bicicleta sem estoque.");
			precoBicicletas += bicicleta.getValor();
		}	
		
		Locacao locacao = new Locacao();
		locacao.setBicicletas(bicicletas);
		locacao.setCliente(cliente);
		locacao.setDataLocacao(new Date());
		locacao.setValorLocacao(precoBicicletas);
		
		//Definir a entrega para 3 dias depois.
		Date dataEntrega = novaDataComDiferencaDeDias(3);
		locacao.setDataRetorno(dataEntrega);

		
		//Salvando a locacao...	
		//O m�todo salvar() ser� implementado com o avan�ar do curso.

		return locacao;
	}

}