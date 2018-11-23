package com.accenture.ejemploSerenityCucumber.pages;

import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.accenture.ejemploSerenityCucumber.utilities.Excel;

import net.serenitybdd.core.pages.WebElementFacade;
import java.util.stream.Collectors;

import net.serenitybdd.core.annotations.findby.FindBy;

import net.thucydides.core.pages.PageObject;

import java.util.List;
import java.util.Map;

@DefaultUrl("http://tutorialsninja.com/demo/index.php?route=account/logout")
public class DictionaryPage extends PageObject {

	@FindBy(xpath = "//span[@class='caret']")
	private WebElementFacade btnMyAccount;

	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//li/a[contains(text(),'Login')]")
	private WebElementFacade lbLogin;

	@FindBy(xpath = "//input[@id='input-email']")
	private WebElementFacade txtEmail;

	@FindBy(xpath = "//input[@id='input-password']")
	private WebElementFacade txtPassword;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElementFacade btnLogin;

	@FindBy(xpath = "//a[@class='dropdown-toggle'][contains(text(),'Components')]")
	private WebElementFacade lbComponentes;

	@FindBy(xpath = "//a[contains(text(),'Show All Components')]")
	private WebElementFacade lbShowAllComponents;

	// @FindBy(xpath =
	// "//div[@class='list-group']/a[starts-with(text(),'Cameras')]")
	// private WebElementFacade listGroup;
	private WebElement listGroup;

	// @FindBy(xpath = "//*[@class='caption']//h4//a[contains(text(),'Canon EOS
	// 5D')]")
	// private WebElementFacade btnAnadirACarrito;
	private WebElement btnAnadirACarrito;

	@FindBy(xpath = "//select[@id='input-option226']")
	private WebElementFacade listaSelectColor;

//    @FindBy(xpath = "//option[contains(text(),'Red')]")
//    private WebElementFacade OptColor;
	private WebElement OptColor;

    @FindBy(xpath = "//input[@id='input-quantity']")
    private WebElementFacade txtQty;


	@FindBy(xpath = "//button[@id='button-cart']")
	private WebElementFacade btnAddCart;

	@FindBy(xpath = "//body/header/div[@class='container']/div[@class='row']/div[@class='col-sm-3']/div[@id='cart']/button[1]")
	private WebElementFacade btnItems;

//    @FindBy(xpath = "//table[@class='table table-striped'][//tr//a[contains(text(),'Canon EOS 5D')] and //td[contains(text(),'x 20')]]")
//    private WebElementFacade lbCantidadProductos;
	private WebElement lbCantidadProductos;

	public void AbrioVentanaLogin() {
		// TODO Auto-generated method stub
		btnMyAccount.waitUntilClickable().click();
		lbLogin.waitUntilVisible().click();

	}

	public void ingresar_usuario(String usuario) {
		// TODO Auto-generated method stub
		txtEmail.type(usuario);

	}

	public void ingresar_clave(String clave) {
		// TODO Auto-generated method stub
		txtPassword.type(clave);
	}

	public void ingresar() {
		// TODO Auto-generated method stub
		btnLogin.click();
	}

	public void seleccionarTodosLosComponentes() {
		// TODO Auto-generated method stub
		lbComponentes.waitUntilClickable().click();
		lbShowAllComponents.waitUntilVisible().click();
	}

	public void seleccionarTipoProducto(String componente, String tipoProducto) {
		// TODO Auto-generated method stub
		
		if (tipoProducto.equals("NA"))
		{
			listGroup = getDriver().findElement(By.xpath("//div[@class='list-group']/a[starts-with(text(),'" + componente + "')]"));
			listGroup.click();
		}
		else
		{
			listGroup = getDriver().findElement(By.xpath("//div[@class='list-group']/a[starts-with(text(),'" + componente + "')]"));
			listGroup.click();
			listGroup = getDriver().findElement(By.xpath("//a[contains(text(),'- "+ tipoProducto +"')]"));
			listGroup.click();
		}
		

	}

	public void anadirProductoACarrito(String referencia, String caracteristica, int cantidad) {
		// TODO Auto-generated method stub
		
		btnAnadirACarrito = getDriver().findElement(By.xpath("//*[@class='caption']//h4//a[contains(text(),'"+ referencia +"')]"));
		btnAnadirACarrito.click();
		
		if (!caracteristica.equals("NA")) 
		{
			//Abrir lista de Seleccionar color
			listaSelectColor.waitUntilVisible().click();
			//Seleccionar color
			OptColor = getDriver().findElement(By.xpath("//option[contains(text(),'"+ caracteristica +"')]"));
			OptColor.click();
		}
		
		//Se ingresa cantidad de unidades a comprar
		txtQty.waitUntilEnabled().type(Integer.toString(cantidad));
		//Se añade a carrito
		btnAddCart.waitUntilClickable().click();
	}

	public boolean validarCantidadProductos(String referencia, int cantidad) {
		// TODO Auto-generated method stub

		btnItems.waitUntilClickable().click();

		lbCantidadProductos = getDriver()
				.findElement(By.xpath("//table[@class='table table-striped'][//tr//a[contains(text(),'" + referencia
						+ "')] and //td[contains(text(),'x " + Integer.toString(cantidad) + "')]]"));
		if (lbCantidadProductos.isEnabled()) {
			return true;
		} else {
			return false;
		}
	}

}