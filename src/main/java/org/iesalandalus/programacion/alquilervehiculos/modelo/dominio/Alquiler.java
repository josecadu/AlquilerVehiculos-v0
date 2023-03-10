package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

import javax.naming.OperationNotSupportedException;

public class Alquiler {
	public static DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private static final int PRECIO_DIA=20;
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	private Cliente cliente;
	private Vehiculo turismo;
	
	public Alquiler(Cliente cliente, Vehiculo turismo, LocalDate fechaAlquiler) {
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
		
	}
	public Alquiler(Alquiler alquiler) {
		if (alquiler == null)
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		setCliente(new Cliente (alquiler.getCliente()));
		setTurismo(new Vehiculo (alquiler.getTurismo()));
		setFechaAlquiler(alquiler.getFechaAlquiler());
		if (fechaDevolucion!=null)
		setFechaDevolucion(alquiler.getFechaDevolucion());
			
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	private void setFechaAlquiler(LocalDate fechaAlquiler) { 
		if (fechaAlquiler==null)
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		
		if (fechaAlquiler.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		this.fechaAlquiler = fechaAlquiler;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	private void setFechaDevolucion(LocalDate fechaDevolucion) {
		if (fechaDevolucion==null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		if (fechaDevolucion.isAfter(LocalDate.now()))
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		if (fechaDevolucion.equals(fechaAlquiler) || fechaDevolucion.isBefore(fechaAlquiler))
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		this.fechaDevolucion = fechaDevolucion;
		
	}
	public Cliente getCliente() {
		return cliente;
	}
	private void setCliente(Cliente cliente) {
		if (cliente==null)
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		this.cliente =cliente;
		
	}
	public Vehiculo getTurismo() {
		return turismo;
	}
	private void setTurismo(Vehiculo turismo) {
		if (turismo==null)
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		this.turismo = turismo;
	
		
	}
	public void devolver(LocalDate fechaDevolucion) throws OperationNotSupportedException {
		if (fechaDevolucion==null)
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		if (getFechaDevolucion()!=null)
			throw new OperationNotSupportedException("ERROR: La devolución ya estaba registrada.");
		setFechaDevolucion(fechaDevolucion);
	
	}
	public int getPrecio() {
		LocalDate fecha1 = getFechaAlquiler();
		
		LocalDate fecha2 = getFechaDevolucion();
		if (fecha2!=null)
		{
		
		int	factorCilindrada = turismo.getCilindrada()/10;
		int numDias = (int)ChronoUnit.DAYS.between(fecha1, fecha2);
		return (PRECIO_DIA+factorCilindrada)*numDias;
		}
		else return 0;
		
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
		if (fechaDevolucion == null)
		return cliente + " <---> " + turismo + ", " + fechaAlquiler.format(FORMATO_FECHA) + " - " + "Aún no devuelto (" + getPrecio() + "€)";
		else return cliente + " <---> " + turismo + ", " + fechaAlquiler.format(FORMATO_FECHA) + " - " + fechaDevolucion.format(FORMATO_FECHA) + " (" + getPrecio() + "€)";
	}
	}
