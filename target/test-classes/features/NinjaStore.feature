Feature: Add productos en NinjaStore
	Validar que se puedan agregar productos en el carro de compras de  NinjaStore
	como usuario de NinjaStore
	confirmar que se agregue la cantidad y productos anadidos
	
	Scenario: validar adiccion de productos en carrito de compras en NinjaStore
		Given que el usuario ingreso al sitio web de NinjaStore con credenciales
		When el usuario registra compra de productos
		Then el deberia de ver la cantidad de productos seleccionados