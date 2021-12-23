package br.edu.ifpe.jaboatao.ts.servicos;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.exception.NaoPodeDividirPorZeroException;

public class CalculadoraTest {
	CalculadoraService calc;
	
	@BeforeEach
	public void antes() {
		calc = new CalculadoraService();
	}

	@Test
	public void somarDoisNumeros() {
		// Cenário
		int a = 6;
		int b = 2;
//		Calculadora calc = new Calculadora();

		// Ação
		int resultado = calc.somar(a, b);

		// Verificação
		Assertions.assertEquals(8, resultado);
	}

	@Test
	public void subtrairDoisNumeros() {
		// Cenário
		int a = 6;
		int b = 2;
//		Calculadora calc = new Calculadora();

		// Ação
		int resultado = calc.subtrair(a, b);

		// Verificação
		Assertions.assertEquals(4, resultado);
	}

	@Test
	public void dividirDoisNumeros() throws NaoPodeDividirPorZeroException {
		// Cenário
		int a = 6;
		int b = 2;
//		Calculadora calc = new Calculadora();

		// Ação
		double resultado = calc.dividir(a, b);

		// Verificação
		Assertions.assertEquals(3, resultado);
	}

	@Test
	@DisplayName("Exception - Não pode dividir por zero - try catch")
	public void excecao1() {
		// Cenário
		int a = 6;
		int b = 0;
//		Calculadora calc = new Calculadora();

		// Ação
		try {
			calc.dividir(a, b);
			fail("Deveria ter ocorrido um exceção.");
		} catch (NaoPodeDividirPorZeroException e) {
			// TODO: handle exception
			// Verificação
			Assertions.assertEquals("Exception: Divisão por zero.", e.getMessage());
		}
	}

	@Test
	@DisplayName("Exception - Não pode dividir por zero - AssertionThrow")
	public void excecao2() {
		// Cenário
		int a = 6;
		int b = 0;
//		Calculadora calc = new Calculadora();
		
		//Ação
		NaoPodeDividirPorZeroException e = assertThrows(NaoPodeDividirPorZeroException.class, () -> {
			calc.dividir(a, b);
		},"Deveria ter ocorrido um exceção." );
		
		//Verificacao
		Assertions.assertEquals("Exception: Divisão por zero.", e.getMessage());
	}
}
