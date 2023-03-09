package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;



public class Alquileres {
	private static List<Alquiler> coleccionAlquileres;

	public Alquileres() {
		coleccionAlquileres=new ArrayList<>();
	}



	public List<Alquiler> get() {
		List<Alquiler> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionAlquileres);
		return nuevaColeccion;
	}



	public List<Alquiler> get(Cliente cliente){

		List<Alquiler> coleccionParaCliente = new ArrayList<>();
		for (Alquiler alquilercliente : coleccionAlquileres)
			if (alquilercliente.getCliente().equals(cliente)) {
				coleccionParaCliente.add((Alquiler) coleccionAlquileres);
			}
		return coleccionParaCliente;
	}



	public List<Alquiler> get(Turismo turismo){

		List<Alquiler> coleccionParaTurismo = new ArrayList<>();
		for (Alquiler alquilerturismo : coleccionAlquileres)
			if (alquilerturismo.getTurismo().equals(turismo)) {
				coleccionParaTurismo.add( (Alquiler) coleccionAlquileres);
			}
		return coleccionParaTurismo;
	}
	public int getCantidad(){
		return coleccionAlquileres.size();


	}



	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		if (cliente==null)
			throw new NullPointerException("ERROR: El cliente noi puede ser nulo.");
		if (turismo==null)
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");

		for (Alquiler alq : get(cliente)) {
			if (alq.getFechaDevolucion()==null) {
				throw new NullPointerException("ERROR: El cliente tiene otro alquiler sin devolver.");
			}
			if (alq.getFechaDevolucion().isAfter(fechaAlquiler)|| alq.getFechaDevolucion().equals(fechaAlquiler)) {
				throw new IllegalArgumentException("ERROR: El cliente tiene un alquiler posterior.");
			}
		}

		for (Alquiler alq :get(turismo)) {
			if (alq.getFechaDevolucion()==null) {
				throw new NullPointerException("ERROR: El turismo actualmente esta alquilado. ");
			}
			if (alq.getFechaDevolucion().isAfter(fechaAlquiler)|| alq.getFechaDevolucion().equals(fechaAlquiler)) {
				throw new IllegalArgumentException("ERROR: El turismo tiene un alquiler posterior.");
			}
		}

	}



	public void insertar(Alquiler alquiler) throws OperationNotSupportedException {
		int indice;
		indice = coleccionAlquileres.indexOf(alquiler);
		if (indice !=-1 )
			throw new OperationNotSupportedException("ERROR: Ya existe un alquiler con esos datos.");
		if (alquiler==null)
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		else
			coleccionAlquileres.add(alquiler);	
	}


	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler ==null) 
			throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
		
		if (fechaDevolucion ==null) 
		
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		
		if (coleccionAlquileres.contains(alquiler))
			throw new OperationNotSupportedException("ERROR: No existe ningun alquiler igual.");
		
		alquiler.devolver(fechaDevolucion);
		}
	
	
	
	
	public Alquiler buscar(Alquiler alquiler){
		int indice;
		indice = coleccionAlquileres.indexOf(alquiler);
		if (alquiler==null)
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		if (indice !=-1)
			return	coleccionAlquileres.get(indice);
		else
			return null;
	}



	public void borrar(Alquiler alquiler) throws OperationNotSupportedException{
		int indice;
		indice = coleccionAlquileres.indexOf(alquiler);
		if (alquiler==null)
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		else
			coleccionAlquileres.remove(indice);
	}
}

