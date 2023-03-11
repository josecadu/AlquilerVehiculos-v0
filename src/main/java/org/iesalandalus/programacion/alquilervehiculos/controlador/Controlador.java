package org.iesalandalus.programacion.alquilervehiculos.controlador;

import java.time.LocalDate;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.ModeloCascada;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;

public class Controlador {
	private ModeloCascada modeloCascada;
	private Vista vista;
	
	public Controlador(ModeloCascada modeloCascada, Vista vista) {
		if(modeloCascada==null)
			throw new NullPointerException("ERROR: el modelo no puede ser nulo.");
		if(vista==null)
			throw new NullPointerException("ERROR: la vsita no puede ser null.");
		this.modeloCascada=modeloCascada;
		this.vista=vista;
		vista.setControlador(this);
	}
	public void comenzar() {
		modeloCascada.comenzar();
		vista.comenzar();
	}
	public void terminar() {
		modeloCascada.terminar();
		vista.terminar();
	}
	public void insertar(Cliente cliente) throws OperationNotSupportedException  {
		modeloCascada.insertar(cliente);
	}
	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {
		modeloCascada.insertar(turismo);
	}
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		modeloCascada.insertar(alquiler);
	}
	public Cliente buscar(Cliente cliente) {
		
		return modeloCascada.buscar(cliente);
	}
	public Object buscar(Object turismo) {
		return modeloCascada.buscar(turismo);
		
	}
	public Alquiler buscar(Alquiler alquiler) {
		return modeloCascada.buscar(alquiler);
		
	}
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException {
		modeloCascada.modificar(cliente, nombre, telefono);
	}
	public void devolver(Alquiler alquiler,LocalDate fechaDevolucion) throws OperationNotSupportedException {
		modeloCascada.devolver(alquiler, fechaDevolucion);
	}
	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		modeloCascada.borrar(cliente);
	}	
	public void borrar(Object turismo) throws OperationNotSupportedException {
		modeloCascada.borrar(turismo);
	}	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException {
		modeloCascada.borrar(alquiler);
	}	
	public List<Cliente> getClientes(){
		return modeloCascada.getClientes();
	}
	public List<Vehiculo> getTurismos(){
		return modeloCascada.getTurismos();
	}
	public List<Alquiler> getAlquileres(){
		return modeloCascada.getAlquileres();
	}
	
	public List<Alquiler> getAlquileres(Cliente cliente){
		return modeloCascada.getAlquileres(cliente);
	}
	public List<Alquiler> getAlquileres(Object turismo){
		return modeloCascada.getAlquileres(turismo);
	}
}
