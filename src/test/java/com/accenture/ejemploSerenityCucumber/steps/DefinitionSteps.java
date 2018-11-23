package com.accenture.ejemploSerenityCucumber.steps;

import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Map;

import com.accenture.ejemploSerenityCucumber.steps.serenity.EndUserSteps;
import com.accenture.ejemploSerenityCucumber.utilities.Excel;

public class DefinitionSteps {

	@Steps
	EndUserSteps anna;
	
	//Se lee el excel
    Excel libroExcel = new Excel("DatosEntrada.xlsx");
	Map<Integer, List<String>> libro = libroExcel.Lectura();
	

	@Given("^que el usuario ingreso al sitio web de NinjaStore con credenciales$")
	public void que_el_usuario_ingreso_al_sitio_web_de_ninjastore_con_credenciales_somethingsomething()
			throws Exception {
		
		String usuario = libro.get(1).get(0);
		String clave = libro.get(1).get(1);
		
		anna.abrir_pagina();
		anna.abreVentanaLogin();
		anna.ingresa_usuario(usuario);
		anna.ingresa_clave(clave);
		anna.ingresa();

	}

	@When("^el usuario registra compra de productos$")
	public void el_usuario_registra_compra_de_productos() throws Exception {
		int i = 3;
		String componente;
		String tipoProducto;
		String referencia;
		String caracteristica;
		int cantidad;
		
		while (i < libro.size()) {
			componente = libro.get(i).get(0);
			tipoProducto = libro.get(i).get(1);
			referencia = libro.get(i).get(2);
			caracteristica = libro.get(i).get(3);
			cantidad = (int)Double.parseDouble(libro.get(i).get(4));
			
			anna.seleccionaTodosLosComponentes();
			anna.seleccionaTipoProducto(componente, tipoProducto);
			anna.anadeProductoACarrito(referencia , caracteristica , cantidad);
			i++;
		}
		
	}

	@Then("^el deberia de ver la cantidad de productos seleccionados$")
	public void el_deberia_de_ver_la_cantidad_de_productos_seleccionados() throws Exception {
		int i = 3;
		String referencia;
		int cantidad;
		
		referencia = libro.get(i).get(2);
		cantidad = (int)Double.parseDouble(libro.get(i).get(4));
		
		while (i < libro.size()) {
			assertTrue(anna.validaCantidadProductos(referencia, cantidad));
			i++;
		}
		
	}

}