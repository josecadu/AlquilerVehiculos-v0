package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Vehiculo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Vehiculos;

public class Modelo {
	private Clientes clientes;
	private Vehiculos turismos;
	private Alquileres alquileres;
	public Modelo() {	
	}
	public void comenzar() {
		clientes = new Clientes();
		turismos = new Vehiculos();
		alquileres = new Alquileres();

	}
	public void terminar() {
		System.out.println("El modelo ha terminado.");
	}


	public void insertar(Cliente cliente) throws OperationNotSupportedException {

		clientes.insertar(new Cliente(cliente));

	}
	public void insertar(Vehiculo turismo) throws OperationNotSupportedException {

		turismos.insertar(new Vehiculo(turismo));

	}
	public void insertar(Alquiler alquiler)  throws OperationNotSupportedException {
		if (alquiler== null)
			throw new NullPointerException("ERROR: No se puede insertar unn alquiler nulo.");
		Cliente cliente = clientes.buscar(alquiler.getCliente());
		Object turismo = turismos.buscar(alquiler.getTurismo());
		if (cliente== null || turismo==null)
			throw new OperationNotSupportedException("ERROR: No existe cliente del alquiler.");
		alquileres.insertar(new Alquiler(alquiler));
	}
	public Cliente buscar(Cliente cliente) {
		Cliente clienteB = clientes.buscar (cliente);
		
		if (clienteB==null)
			return null;
		else return new Cliente(clienteB.getNombre(),clienteB.getDni(),clienteB.getTelefono());
		

	}
	public Object buscar(Object turismo) {
		Vehiculo turismoB = turismos.buscar (turismo);
		if (turismoB==null)
			return null;
		else return new Vehiculo(turismoB.getMarca(),turismoB.getModelo(),turismoB.getCilindrada(),turismoB.getMatricula());
	}
	public Alquiler buscar(Alquiler alquiler) {
		Alquiler alquilerB = alquileres.buscar(alquiler);
		if (alquilerB==null)
			return null;
		else return new Alquiler(alquilerB.getCliente(),alquilerB.getTurismo(),alquilerB.getFechaAlquiler());
	}
	public void modificar(Cliente cliente,String nombre, String telefono) throws OperationNotSupportedException {
		if (cliente== null)
			throw new NullPointerException("ERROR: No hay un cliente con ese DNI.");
		clientes.modificar( cliente, nombre, telefono);
	}
	public void devolver(Alquiler alquiler , LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (alquiler==null)
			throw new NullPointerException("ERROR: Ese alquiler no existe.");
		alquileres.devolver(alquiler, fechaDevolucion);
	}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {

		clientes.borrar(cliente);

	} 
	public void borrar(Object turismo) throws OperationNotSupportedException {

		turismos.borrar(turismo);
	}
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException{
		
		alquileres.borrar(alquiler);
	}
	public List<Cliente> getClientes(){
		List<Cliente> getCli = new ArrayList<>();
		for (Cliente cojerCli : clientes.get())
			getCli.add(new Cliente(cojerCli.getNombre(),cojerCli.getDni(),cojerCli.getTelefono()));
		return getCli;
	}
	public List<Vehiculo> getTurismos(){
		List<Vehiculo> getTu = new ArrayList<>();
		for (Vehiculo cojerTu : turismos.get())
			getTu.add(new Vehiculo(cojerTu.getMarca(),cojerTu.getModelo(),cojerTu.getCilindrada(),cojerTu.getMatricula()));
		return getTu;
	}
	public List<Alquiler> getAlquileres(){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get())
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getTurismo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
	public List<Alquiler> getAlquileres(Cliente cliente){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get(cliente))
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getTurismo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
	public List<Alquiler> getAlquileres(Object turismo){
		List<Alquiler> getAl = new ArrayList<>();
		for (Alquiler cojerAl : alquileres.get(turismo))
			getAl.add(new Alquiler(cojerAl.getCliente(),cojerAl.getTurismo(),cojerAl.getFechaAlquiler()));
		return getAl;
	}
}
	

