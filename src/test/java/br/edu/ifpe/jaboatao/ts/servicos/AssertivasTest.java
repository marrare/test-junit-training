package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import br.edu.ifpe.jaboatao.ts.entidades.Cliente;

@DisplayName("Assertivas do JUnit5.")
public class AssertivasTest {

	@Test
	@DisplayName("AssertTrue()")
	public void teste01() {
		Assertions.assertTrue(true, "Era esperado true mas veio false.");
		Assertions.assertFalse(false);
	}
	@Test
	@DisplayName("AssertEquals()")
	public void teste02() {
		Assertions.assertEquals(1, 1);
		Assertions.assertNotEquals(1, 1.2);
		Assertions.assertEquals(1.1, 1.1);
		Assertions.assertEquals(Math.PI, 3.14, 0.01);
		
		Assertions.assertEquals("casa", "casa");
		Assertions.assertEquals("casa", "casa");
		Assertions.assertTrue("casa".equalsIgnoreCase("Casa"));
		
		Cliente cliente01 = new Cliente("Cliente 01");
		Cliente cliente02 = new Cliente("Cliente 01");
		
		Assertions.assertEquals(cliente01, cliente02);
	}
	
	@Test
	@DisplayName("AssertSame()")
	public void teste03() {
		Cliente cliente01 = new Cliente("Cliente 01");
		Cliente cliente02 = cliente01;
		Cliente cliente03 = new Cliente("Cliente 03");
		
		Assertions.assertSame(cliente01, cliente02);
		Assertions.assertNotSame(cliente01, cliente03);
	}
	
	@Test
	@DisplayName("AssertNull()")
	public void teste04() {
		Cliente cliente01 = null;
		Cliente cliente02 = new Cliente("Cliente 02");
		
		Assertions.assertNull(cliente01);
		Assertions.assertNotNull(cliente02);
	}
	
	@Test
	@DisplayName("AssertAll()")
	public void teste05() {
		Assertions.assertAll(
			() -> Assertions.assertEquals(1, 1, "Os valores era para ser iguais."),
			() -> Assertions.assertNotEquals(1, 1.1, "1 era para ser diferente de 1"),
			() -> Assertions.assertTrue(true, "Era esperado true mas veio false")
		);
	}
}
