package dev.leonardo.automation.cep.pages;

import org.openqa.selenium.By;

public class BuscaCepText extends BasePage {
	private By cepLocator = By.id("endereco");
	private By searchButtonLocator = By.id("btn_pesquisar");
	private By cepTagLocator = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]");
	
	public void insertCepText() {
		if(super.isDisplayed(cepLocator)) {
			super.type("Lojas Bemol", cepLocator);
			super.click(searchButtonLocator);
		}else {
			System.out.println("CEP textbox was not present.");
		}
	}
	public String getCepResultText() {
		return super.getText(cepTagLocator);
	}
}
