package org.iesalandalus.programacion.alquilervehiculos.controlador;

import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private Modelo modelo;
	private Vista vista;
	
	public Controlador(Modelo modelo, Vista vista) {
		if(modelo==null)
			throw new NullPointerException("ERROR: el modelo no puede ser nulo.");
		if(vista==null)
			throw new NullPointerException("ERROR: la vsita no puede ser null.");
		this.modelo=modelo;
		this.vista=vista;
		vista.setControlador(this);
	}
	
	
}
