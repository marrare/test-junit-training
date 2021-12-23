package br.edu.ifpe.jaboatao.ts.servicos;

import static br.edu.ifpe.jaboatao.ts.utils.ManipulandoDatas.novaDataComDiferencaDeDias;

import java.util.Date;
import java.util.List;

import br.edu.ifpe.jaboatao.ts.entidades.Bicicleta;
import br.edu.ifpe.jaboatao.ts.entidades.Cliente;
import br.edu.ifpe.jaboatao.ts.entidades.Locacao;
import br.edu.ifpe.jaboatao.ts.exception.LocacaoException;

public class LocacaoService {
	
	public Locacao alugarBicicleta(Cliente cliente, List<Bicicleta> bicicletas) throws LocacaoException {
		
		Double precoBicicletas = 0.0;
		
		if (bicicletas == null || bicicletas.isEmpty()) throw new LocacaoException("bicicleta vazia.");
		if (cliente == null) throw new LocacaoException("cliente vazio.");
		for( int i = 0; i < bicicletas.size(); i++ ) {
			Bicicleta bicicleta = bicicletas.get(i);
			if (bicicleta.getEstoque() == 0) throw new LocacaoException("Bicicleta sem estoque.");
			
			double valor = bicicleta.getValor();
			switch(i) {
				case 1: precoBicicletas += valor * 0.90; break; 
				case 2: precoBicicletas += valor * 0.85; break;
				case 3: precoBicicletas += valor * 0.75; break;
				case 4: precoBicicletas += valor * 0.50; break;
				default: precoBicicletas += valor; break;
			}
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