package dev.leonardo.automation.cep.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import dev.leonardo.automation.cep.pages.BasePage;
import dev.leonardo.automation.cep.pages.BuscaCep;

class BuscaCepTest extends BasePage {
	private BuscaCep buscaCep;
	private final String URL = "https://buscacepinter.correios.com.br/app/endereco/index.php";

	@BeforeEach
	void setUp() throws Exception {
		buscaCep = new BuscaCep();
		buscaCep.visit(URL);
	}

	@AfterEach
	void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	void InsertCepNumber() {
		//when
		buscaCep.insertCep();
		
		//then
		Assertions.assertTrue(this.buscaCep.getCurrentUrl().equals(this.URL));
	}

}
