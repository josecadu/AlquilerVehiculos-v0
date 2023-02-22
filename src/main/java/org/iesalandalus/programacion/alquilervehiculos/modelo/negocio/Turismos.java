package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos {
	private static List<Turismo> coleccionTurismos;
	
	public Turismos() {
		coleccionTurismos = new ArrayList<>();
	}
	
	
	
	public List<Turismo> get(){
		List<Turismo> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionTurismos);
		return nuevaColeccion;	
	}
	
	
	
	public int getCantidad() {
		return coleccionTurismos.size();
	}
	
	
	
	public void insertar(Turismo turismo) throws OperationNotSupportedException {
		int indice;
		indice = coleccionTurismos.indexOf(turismo);
		if(turismo==null)
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		
		if (indice !=-1 && turismo!=null)
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		else
			coleccionTurismos.add(turismo);	
	}
	
	
	
	public Turismo buscar(Turismo turismo) {
	
	int indice;
	indice = coleccionTurismos.indexOf(turismo);
	if(turismo==null)
		throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
	
	if (indice !=-1)
		return	coleccionTurismos.get(indice);
	else
		return null;
	}
	
	
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException{
		int indice;
		indice = coleccionTurismos.indexOf(turismo);
		if(turismo==null)
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		else
			coleccionTurismos.remove(indice);
	}
}
