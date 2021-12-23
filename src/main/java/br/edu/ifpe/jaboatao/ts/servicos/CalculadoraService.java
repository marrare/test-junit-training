package br.edu.ifpe.jaboatao.ts.servicos;

import br.edu.ifpe.jaboatao.ts.exception.NaoPodeDividirPorZeroException;

public class CalculadoraService {

	public int somar(int a, int b) {
		return a+b;
	}

	public int subtrair(int a, int b) {
		return a-b;
	}

	public double dividir(int a, int b) throws NaoPodeDividirPorZeroException {
		if (b == 0) {
			throw new NaoPodeDividirPorZeroException("Exception: Divisão por zero.");
		}
		return a/b;
	}
}
