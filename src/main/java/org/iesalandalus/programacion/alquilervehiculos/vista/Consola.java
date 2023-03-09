package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.utilidades.Entrada;


public class Consola {
private final static String PATRON_FECHA = "^([0][1-9]|[12][0-9]|3[01])(\\/|-)([0][1-9]|[1][0-2])\\2(\\d{4})(\\s)([0-1][1-9]|[2][0-3])(:)([0-5][0-9])$";
private final static DateTimeFormatter FORMATO_FECHA= DateTimeFormatter.ofPattern("dd/MM/yyyy");
private Consola() {
	
}
public static void mostrarCabecera(String mensaje) {

	System.out.println(mensaje);
	System.out.println("_".repeat(mensaje.length()));
}
public static void mostrarMenu() {
	System.out.println("__________________BIENVENIDO__________________");
	System.out.println("_Este es el sistema de alquiler de vehiculos._");
	System.out.println("______________________________________________");
	System.out.println("___________________OPCIONES___________________");
	System.out.println("______________________________________________");
	System.out.println("____________1___INSERTAR_CLIENTE______________");
	System.out.println("____________2___INSERTAR_TURISMO______________");
	System.out.println("____________3___INSERTAR_ALQUILER_____________");
	System.out.println("____________4___BUSCAR_CLIENTE________________");
	System.out.println("____________5___BUSCAR_TURISMO________________");
	System.out.println("____________6___BUSCAR_ALQUILE________________");
	System.out.println("____________7___MODIFICAR_CLIENTE_____________");
	System.out.println("____________8___DEVOLVER_ALQUILER_____________");
	System.out.println("____________9___BORRAR_CLIENTE________________");
	System.out.println("____________10__BORRAR_TURISMO________________");
	System.out.println("____________11__BORRAR_ALQUILE________________");
	System.out.println("____________12__LISTAR_CLIENTES_______________");
	System.out.println("____________13__LISTAR_TURISMOS_______________");
	System.out.println("____________14__LISTAR_ALQUILERES_____________");
	System.out.println("____________15__LISTAR_ALQUILERES_CLIENTE_____");
	System.out.println("____________16__LISTAR_ALQUILERES_TURISMO_____");
	System.out.println("______________________________________________");
	System.out.println("____________0________SALIR____________________");
}
	private static String leerCadena(String mensaje) {
		System.out.println(mensaje);
		return Entrada.cadena();
	}
	private static Integer leerEntero(String mensaje) {
		System.out.println(mensaje);
		return Entrada.entero();
	}
	private static LocalDate leerFecha(String mensaje) {
		String fechaInt;
		do {
		System.out.println(mensaje);
		fechaInt=Entrada.cadena();
		}
		while (!fechaInt.matches(PATRON_FECHA));
		
		return LocalDate.parse(fechaInt ,FORMATO_FECHA);
			
	}
	public static Opcion elegirOpcion() {
		Opcion opcionElegida=null;
		boolean i=false;
		int opcion = leerEntero("Elija una opcion: ");
		  while (i == false) { 
	            try {
	                opcionElegida = Opcion.get(opcion);
	                i = true;
	            } catch (Exception E) {	        
	               opcion = leerEntero("Elija de nuevo, una opción correcta: ");
	            }
	        }
		return opcionElegida;
	}
	public static Cliente leerCliente() {
		String nombre=leerCadena("Introduzca el nombre del cliente: ");
		String dni=leerCadena("Introduzaca el DNI del cliente: ");
		String telefono=leerCadena("introduzca el telefono del cliente: ");
		return new Cliente(nombre, dni, telefono);
	}
	public static Cliente leerClienteDni() {
		String dni=leerCadena("Introduzaca el DNI del cliente: ");
		return Cliente.getClienteConDni(dni);
	}
	public static String leerNombre() {
	return leerCadena("Introduzca un nombre: ");
		
	}
	public static String leerTelefono() {
	return leerCadena("introduzca un telefono: ");
	}
	
	public static Turismo leerTurismo() {
		String marca=leerCadena("Introduzca la marca del vehiculo: ");
		String modelo=leerCadena("Introduzca el modelo del vehiculo: ");
		int cilindrada=leerEntero("Introduzca la cilindrada del vehiculo: ");
		String matricula=leerCadena("Introduzca la matricula del vehiculo: ");
		return new Turismo(marca,modelo,cilindrada,matricula);
	}
	public static Turismo leerTurismoMatricula() {
		String matricula=leerCadena("Introduzaca el la matricula del turismo: ");
		return Turismo.getTurismoConMatricula(matricula);
	}
	public static Alquiler leerAlquiler() {
		Cliente cliente=leerClienteDni();
		Turismo turismo=leerTurismoMatricula();
		LocalDate fechaAlquiler=leerFecha("Introduzca la fecha de alquiler: ");
		return new Alquiler(cliente,turismo,fechaAlquiler);
	}
	public static LocalDate leerFechaDevolucion() {
		LocalDate fechaDevolucion=leerFecha("Introduzca la fecha de devolución: ");
		return fechaDevolucion;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
