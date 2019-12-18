package seleniumgluecode;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Test {

	By searchLocator = By.name("q");
	By linkLocator = By.className("LC20lb");
	By searchFalabellaLocator = By.id("searchQuestionSolr");
	By productsLocator = By.xpath("//*[@data-pod=\"catalyst-pod\"]");
	By agregarLocator = By.cssSelector("div.fb-product-cta__controls--actions.fb-product-cta__controls--actions-pdp > button");
	By seguirComprandoLocator = By.xpath("/html/body/div[5]/div/div/div/div/div[2]/div[3]/a");
	By bolsaLocator = By.cssSelector("div.fb-masthead-item__main.fb-masthead-basket");
	By headerLocator = By.cssSelector("div.headerContainer > span.title");
	By incrementarLocator = By.className("increase");
	By comboLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[1]/section/section/div/div/div/form/div/a");
	By garantiaLocator = By.className("fb-inline-dropdown__item-link");
	By irAComprarLocator = By.xpath("//*[@id=\"root\"]/div[2]/div[2]/div/form/div[2]/div[2]/div[2]/button");
	By despachoLocator = By.className("fbra_deliveryOptionsTitle__heading");
	
	//By subTotalLocator = By.className("fb-order-status__sub-totals__value notranslate");
	//By totalLocator = By.className("fbra_text fbra_test_orderSummary__totalCostPrice fbra_orderSummary__totalCostPrice");

	private WebDriver driver = Hooks.getDriver();
		

	@Given("^El usuario ingreso en la pagina de falabella a travez de google$")
	public void el_usuario_ingreso_en_la_pagina_de_falabella_a_travez_de_google() throws Throwable {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(searchLocator));

		WebElement searchGoogle = driver.findElement(searchLocator);
		searchGoogle.clear();
		searchGoogle.sendKeys("Falabella");
		searchGoogle.submit();
		
		ewait.until(ExpectedConditions.presenceOfElementLocated(linkLocator));
		List<WebElement> listLinks = driver.findElements(linkLocator);
		
		WebElement link = null;

		for (int i = 0; i < listLinks.size(); i++) {

			if (listLinks.get(i).getText().contentEquals("Falabella.com - Mejor Compra Online")) {

				listLinks.get(i).click();
				link = listLinks.get(i);
				i = listLinks.size();
			}
		}

		if (link != null) {
			new Actions(driver).moveToElement(link).perform();
			link.click();
		} else {
			System.out.println("el link Falabella.com - Mejor Compra Online no existe");
		}

	}

	@When("^Busco un producto$")
	public void busco_un_producto() throws Throwable {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(searchFalabellaLocator));
		WebElement searchFalabella = driver.findElement(searchFalabellaLocator);
		searchFalabella.clear();
		searchFalabella.sendKeys("PS4");
		searchFalabella.submit();
	}

	@When("^Entro al detalle del producto$")
	public void entro_al_detalle_del_producto() throws Throwable {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(productsLocator));
		List<WebElement> listProducts = driver.findElements(productsLocator);
		listProducts.get(0).click();
	}

	@When("^Agrego el producto a la bolsa$")
	public void agrego_el_producto_a_la_bolsa() throws Throwable {
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(agregarLocator));
		WebElement agregarAlCarrito = driver.findElement(agregarLocator);
		agregarAlCarrito.click();
	
		ewait.until(ExpectedConditions.presenceOfElementLocated(seguirComprandoLocator));
		WebElement seguirComprando = driver.findElement(seguirComprandoLocator);
		seguirComprando.click();
	}
	
	@When("^Ingreso a la bolsa de compra$")
	public void Ingreso_a_la_bolsa_de_compra() throws Throwable {
		WebElement bolsa = driver.findElement(bolsaLocator);
		bolsa.click();
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(headerLocator));
		assertEquals(driver.findElement(headerLocator).getText(), "Bolsa de Compras");
	}

	@When("^Incrementa en un prodcuto y agrega una gatanria extendida$")
	public void incrementa_en_un_prodcuto_y_agrega_una_gatanria_extendida() throws Throwable {
		
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(incrementarLocator));
		WebElement incrementar = driver.findElement(incrementarLocator);
		incrementar.click();
		
		ewait.until(ExpectedConditions.elementToBeClickable(comboLocator));
		driver.findElement(comboLocator).click();			
		List<WebElement> listGarantias = driver.findElements(garantiaLocator);

		for (int i = 0; i < listGarantias.size(); i++) {

			if (listGarantias.get(i).getText().contains("2 Años")) {

				listGarantias.get(i).click();
				
			}
		}
	
	}

	@When("^Hace click en ir a comprar$")
	public void hace_click_en_ir_a_comprar() throws Throwable {
		
		WebElement irAComprar = driver.findElement(irAComprarLocator);
		irAComprar.click();
		
	}

	@Then("^Se debe haber redirigido a la pantalla de envio$")
	public void se_debe_haber_redirigido_a_la_pantalla_de_envio() throws Throwable {
		
		WebDriverWait ewait = new WebDriverWait(driver, 10);
		ewait.until(ExpectedConditions.presenceOfElementLocated(despachoLocator));
		WebElement despachoTitulo = driver.findElement(despachoLocator);
		assertEquals("Elige tus opciones de despacho", despachoTitulo.getText());
		
	}

}
