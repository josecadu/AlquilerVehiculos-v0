package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion {
SALIR("SALIR"),INSERTAR_CLIENTE("INSERTAR_CLIENTE"),INSERTAR_TURISMO("INSERTAR_TURISMO"),INSERTAR_ALQUILER("INSERTAR_ALQUILER"),
BUSCAR_CLIENTE("BUSCAR_CLIENTE"),BUSCAR_TURISMO("BUSCAR_TURISMO"),BUSCAR_ALQUILER("BUSCAR_ALQUILER"),
MODIFICAR_CLIENTE("MODIFICAR_CLIENTE"),DEVOLVER_ALQUILER("DEVOLVER_ALQUILER"),BORRAR_CLIENTE("BORRAR_CLIENTE"),
BORRAR_TURISMO("BORRAR_TURISMO"),BORRAR_ALQUILER("BORRAR_ALQUILER"),LISTAR_CLIENTES("LISTAR_CLIENTES"),
LISTAR_TURISMOS("LISTAR_TURISMOS"),LISTAR_ALQUILERES("LISTAR_ALQUILERES"),
LISTAR_ALQUILERES_CLIENTE("LISTAR_ALQUILERES_CLIENTE"),LISTAR_ALQUILERES_TURISMO("LISTAR_ALQUILERES_TURISMO");

private String texto;
	
	private Opcion(String texto) {
		
		this.texto=texto;
		
	}
	private boolean esOrdinalValido(int ordinal) {
		Opcion[] opciones =values();
		
		return ordinal >= 0 && ordinal <= opciones.length; 
	}
	public static Opcion get(int ordinal) {
		Opcion opcion;
		switch (ordinal) {
		case 0: 
			opcion =  Opcion.SALIR;
            break;
		case 1: 
			opcion = Opcion.INSERTAR_CLIENTE;
            break;
		case 2: 
			opcion =  Opcion.INSERTAR_TURISMO;
            break;
		case 3: 
			opcion = Opcion.INSERTAR_ALQUILER;
            break;
		case 4: 
			opcion =  Opcion.BUSCAR_CLIENTE;
            break;
		case 5: 
			opcion =  Opcion.BUSCAR_TURISMO;
            break;
		case 6: 
			opcion =  Opcion.BUSCAR_ALQUILER;
            break;
		case 7: 
			opcion =  Opcion.MODIFICAR_CLIENTE;
            break;
		case 8: 
			opcion =  Opcion.DEVOLVER_ALQUILER;
            break;
		case 9: 
			opcion = Opcion.BORRAR_CLIENTE;
            break;
		case 10: 
			opcion = Opcion.BORRAR_TURISMO;
            break;
		case 11: 
			opcion = Opcion.BORRAR_ALQUILER;
            break;
		case 12: 
			opcion =  Opcion.LISTAR_CLIENTES;
            break;
		case 13: 
			opcion =  Opcion.LISTAR_TURISMOS;
            break;
		case 14: 
			opcion =  Opcion.LISTAR_ALQUILERES;
            break;
		case 15: 
			opcion =  Opcion.LISTAR_ALQUILERES_CLIENTE;
            break;
		case 16: 
			opcion = Opcion.LISTAR_ALQUILERES_TURISMO;
            break;
			
		
		default:
			throw new IllegalArgumentException("ERROR: Esa no es una opcion valida.");
		}
		return  opcion;
	}
	@Override
	public String toString() {
		return texto;
	}
}
