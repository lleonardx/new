package dev.leonardo.automation.cep.pages;

import org.openqa.selenium.By;

public class BuscaCep extends BasePage {
	//Locator
	private By cepLocator = By.id("endereco");
	private By searchButtonLocator = By.id("btn_pesquisar");
	private By cepTagLocator = By.xpath("//*[@id=\"resultado-DNEC\"]/tbody/tr/td[1]");
	
	public void insertCep() {
		if(super.isDisplayed(cepLocator)) {
			super.type("69005-040", cepLocator);
			super.click(searchButtonLocator);
		}else {
			System.out.println("CEP textbox was not present.");
		}
		
	}
	public String getCepResult() {
		return super.getText(cepTagLocator);
	}
	
	
	
	

}
