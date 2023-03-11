package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class MainApp {

	public static void main(String[] args) {
	ModeloCascada modeloCascada = new ModeloCascada();
	Vista vista = new Vista();
	Controlador controlador= new Controlador(modeloCascada,vista);
	controlador.comenzar();
	}
}
