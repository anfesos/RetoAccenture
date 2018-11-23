package com.accenture.ejemploSerenityCucumber.steps.serenity;

import com.accenture.ejemploSerenityCucumber.pages.DictionaryPage;
import com.accenture.ejemploSerenityCucumber.utilities.Excel;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import java.util.List;
import java.util.Map;

public class EndUserSteps {
//@Step es un modificador para que serenity sepa cuando debe tomar la captura de pantalla
    DictionaryPage dictionaryPage;
    
    
    
    @Step
	public void abrir_pagina() {
		// TODO Auto-generated method stub
		dictionaryPage.open();
	}
    
    @Step
    public void abreVentanaLogin() {
		// TODO Auto-generated method stub
		dictionaryPage.AbrioVentanaLogin();
	}
    
    @Step
	public void ingresa_usuario(String usuario) {
		// TODO Auto-generated method stub
    	
		dictionaryPage.ingresar_usuario(usuario);
																
	}
    
   
    @Step
	public void ingresa_clave(String clave) {
		// TODO Auto-generated method stub
    	
		dictionaryPage.ingresar_clave(clave);
	}
    
    @Step
	public void ingresa() {
		// TODO Auto-generated method stub
		dictionaryPage.ingresar();
	}
    
    @Step
	public void seleccionaTodosLosComponentes() {
		// TODO Auto-generated method stub
		dictionaryPage.seleccionarTodosLosComponentes();
	}
    
    @Step
	public void seleccionaTipoProducto(String componente, String tipoProducto) {
		// TODO Auto-generated method stub|||||||||																																																																																																																																																																																																																																																																																								111111111111111111111111111111111111111111111111111111111111111111111|	
		dictionaryPage.seleccionarTipoProducto(componente, tipoProducto);
	}
    
    @Step
	public void anadeProductoACarrito(String referencia, String caracteristica, int cantidad) {
		// TODO Auto-generated method stub
		dictionaryPage.anadirProductoACarrito(referencia, caracteristica, cantidad);
	}
	
	
    @Step
	public boolean validaCantidadProductos(String referencia, int cantidad) {
		// TODO Auto-generated method stub
		return dictionaryPage.validarCantidadProductos(referencia, cantidad);
	}
}