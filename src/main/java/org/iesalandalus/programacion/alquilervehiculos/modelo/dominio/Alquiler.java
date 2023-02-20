package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Alquiler {
	public static DateTimeFormatter FORMATO_FECHA;
	private int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Turismo turismo;
	
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
		//this.fechaDevolucion=fechaDevolucion; //por que???
	}
	public Alquiler(Alquiler alquiler) {
		if (alquiler == null)
			throw new NullPointerException("ERROR: No se puede copiar un alquiler nulo");
		setCliente(alquiler.getCliente());
		setTurismo(alquiler.getTurismo());
		setFechaAlquiler(alquiler.getFechaAlquiler());
		setFechaDevolucion(alquiler.getFechaDevolucion());
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	private void setFechaAlquiler(LocalDate fechaAlquiler) { //hay que validar la nulidad de los LocalDate??
		if (fechaAlquiler!=null)
		this.fechaAlquiler = fechaAlquiler;
		else 
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion!=null)
			this.fechaDevolucion = fechaDevolucion;
			else 
				throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente(Cliente cliente) {
		if (cliente!=null)
		this.cliente = cliente;
		else
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
	}
	public Turismo getTurismo() {
		return turismo;
	}
	private void setTurismo(Turismo turismo) {
		if (turismo!=null)
			this.turismo = turismo;
			else
				throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		
	}
	public LocalDate devolver(LocalDate fechaDevolucion) {
	return fechaDevolucion;	
	}
	public int getPrecio() {
		LocalDate fecha1 = getFechaAlquiler();
		LocalDate fecha2 = getFechaDevolucion();
		
		long precioAlqLon;
		int	factorCilindrada = turismo.getCilindrada()/10;
		long numDias = ChronoUnit.DAYS.between(fecha1, fecha2);
		precioAlqLon = (PRECIO_DIA-factorCilindrada)*numDias;
		int precioAlq = (int)precioAlqLon;
		return  precioAlq;
	}
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}
	@Override
	public String toString() {
		return "Alquiler [fechaAlquiler=" + fechaAlquiler + ", fechaDevolucion=" + fechaDevolucion + ", cliente="
				+ cliente + ", turismo=" + turismo + "]";
	}
	
	}
