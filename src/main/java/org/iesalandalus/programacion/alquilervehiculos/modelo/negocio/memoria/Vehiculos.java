package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.memoria;

import java.util.ArrayList;
import java.util.List;
import javax.naming.OperationNotSupportedException;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;

public class Vehiculos {
	private static List<Vehiculo> coleccionVehiculos;
	
	public Vehiculos() {
		coleccionVehiculos = new ArrayList<>();
	}
	
	
	
	public List<Vehiculo> get(){
		List<Vehiculo> nuevaColeccion = new ArrayList<>();
		nuevaColeccion.addAll(coleccionVehiculos);
		return nuevaColeccion;	
	}
	
	
	
	public int getCantidad() {
		return coleccionVehiculos.size();
	}
	
	
	
	public void insertar(Vehiculo vehiculo) throws OperationNotSupportedException {
		int indice;
		indice = coleccionVehiculos.indexOf(vehiculo);
		if(vehiculo==null)
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		
		if (indice !=-1 && vehiculo!=null)
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		else
			coleccionVehiculos.add(vehiculo);	
	}

	
	
	public Vehiculo buscar(Object vehiculo) {
	
	int indice;
	indice = coleccionVehiculos.indexOf(vehiculo);
	if(vehiculo==null)
		throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
	
	if (indice !=-1)
		return	coleccionVehiculos.get(indice);
	else
		return null;
	}
	
	
	
	public void borrar(Object vehiculo) throws OperationNotSupportedException{
		int indice;
		indice = coleccionVehiculos.indexOf(vehiculo);
		if(vehiculo==null)
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		
		if (indice ==-1)
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
		else
			coleccionVehiculos.remove(indice);
	}
}
