package br.edu.ifpe.jaboatao.ts.servicos;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

//@TestMethodOrder(MethodOrderer.Random.class)
//@TestMethodOrder(MethodOrderer.MethodName.class)
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestMethodOrder(MethodOrderer.DisplayName.class)
public class AnotacoesTest {
	
	public static int number = 0;
	
	@BeforeEach
	public void antes() {
		number += 1;
		System.out.println(number);
		System.out.println("Antes - BeforeEach()");
	}
	
	@AfterEach
	public void depois() {
		System.out.println("Depois - AfterEach()");
	}
	
	@BeforeAll
	public static void antesDeTudo() {
		System.out.println("Antes - @BeforeAll()");
	}
	
	@AfterAll
	public static void depoisDeTudo() {
		System.out.println("Depois - @AfterAll()");
	}
	
	@Test
	@Order(2)
	@DisplayName("2")
	public void metodoA() {
		System.out.println("metodoA");
	}
	
	@Test
	@Order(2)
	@DisplayName("1")
	public void metodoB() {
		System.out.println("metodoB");
	}
	
	@Test
	@Order(1)
	@DisplayName("3")
	@Disabled
	public void metodoC() {
		System.out.println("metodoC");
	}

}
