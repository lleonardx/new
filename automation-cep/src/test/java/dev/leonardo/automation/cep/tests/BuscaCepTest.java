package dev.leonardo.automation.cep.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

import dev.leonardo.automation.cep.pages.BasePage;
import dev.leonardo.automation.cep.pages.BuscaCepNumber;
import dev.leonardo.automation.cep.pages.BuscaCepText;

class BuscaCepTest extends BasePage {
	private BuscaCepNumber buscaCep;
	private BuscaCepText buscaCepText;
	private final String URL = "https://buscacepinter.correios.com.br/app/endereco/index.php";
	private final String URL1 = "https://buscacepinter.correios.com.br/app/endereco/index.php";
	
	@BeforeEach
	void setUp() throws Exception {
		buscaCep = new BuscaCepNumber();
		buscaCep.visit(URL);
		
		buscaCepText = new BuscaCepText();
		buscaCepText.visit(URL1);
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
	@Test
	void InserdEndereco() {
		//when
		buscaCepText.insertCepText();
		//then
		Assertions.assertTrue(this.buscaCep.getCurrentUrl().equals(this.URL));
	}
}
