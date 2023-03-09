package org.iesalandalus.programacion.alquilervehiculos.vista;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;

public class Vista {
	private Controlador controlador;

	public void setControlador(Controlador c)
	{
		if(c==null) {
			throw new NullPointerException("ERROR: El controlador no puede ser nulo.");
		}
		this.controlador=c;
	}
	public void comenzar() {
		Opcion opcion;
		do {
			Consola.mostrarMenu();
			opcion=Consola.elegirOpcion();
			ejecutar(opcion);
		}
		while (opcion!=Opcion.SALIR);

	}
	public static void terminar() {
		System.out.println("La vista ha finalizado");
	}
	
	public static void ejecutar(Opcion opcion) {
		
		switch (opcion) {
		case SALIR: 
			terminar();
            break;
		case INSERTAR_CLIENTE: 
			insertarCliente();
            break;
		case INSERTAR_TURISMO: 
			insertarTurismo();
            break;
		case INSERTAR_ALQUILER: 
			insertarAlquiler();
            break;
		case BUSCAR_CLIENTE: 
			buscarCliente();
            break;
		case BUSCAR_TURISMO: 
			buscarTurismo();
            break;
		case BUSCAR_ALQUILER: 
			buscarAlquiler();
            break;
		case MODIFICAR_CLIENTE: 
			modificarCliente();
            break;
		case DEVOLVER_ALQUILER: 
			devolverALquiler();
            break;
		case BORRAR_CLIENTE: 
			borrarCliente();
            break;
		case BORRAR_TURISMO: 
			borrarTurismo();
            break;
		case BORRAR_ALQUILER: 
			borrarAlquiler();
            break;
		case LISTAR_CLIENTES: 
			listarClientes();
            break;
		case LISTAR_TURISMOS: 
			listarTurismos();
            break;
		case LISTAR_ALQUILERES: 
			listarAlquileres();
            break;
		case LISTAR_ALQUILERES_CLIENTE: 
			listarAlquileresCliente();
            break;
		case LISTAR_ALQUILERES_TURISMO: 
			listarAlquileresTurismo();
            break;
		}
	}

	private void insertarCliente(){
		 Consola.mostrarCabecera("Selecciono insertar cliente");
	        try {
	            controlador.insertar(Consola.leerCliente());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
    
	private void insertarTurismo() {
		 Consola.mostrarCabecera("Selecciono insertar turismo");
	        try {
	            controlador.insertar(Consola.leerTurismo());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
    
	private void insertarAlquiler() {
		 Consola.mostrarCabecera("Selecciono insertar alquiler");
	        try {
	            controlador.insertar(Consola.leerAlquiler());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
   
	private void buscarCliente() {
		 Consola.mostrarCabecera("Selecciono buscar cliente");
	        try {
	            System.out.println(controlador.buscar(Consola.leerCliente()));
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
   
	private void buscarTurismo() {
		 Consola.mostrarCabecera("Selecciono buscar turismo");
	        try {
	            System.out.println(controlador.buscar(Consola.leerTurismo()));
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
   
	private void buscarAlquiler() {
		 Consola.mostrarCabecera("Selecciono buscar alquiler");
	        try {
	            System.out.println(controlador.buscar(Consola.leerAlquiler()));
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	private void modificarCliente() {
		 Consola.mostrarCabecera("Selecciono modificar cliente");
	        try {
	            controlador.modificar(Consola.leerClienteDni(),Consola.leerCliente(),Consola.leerTelefono());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	private void devolverALquiler() {
		Consola.mostrarCabecera("Selecciono devolver alquiler");
        try {
            controlador.devolver(Consola.leerAlquiler(),Consola.leerFechaDevolucion());
        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
		
	}

	private void borrarCliente() {
		 Consola.mostrarCabecera("Selecciono borrar cliente");
	        try {
	           controlador.borrar(Consola.leerCliente());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
 
	private void borrarTurismo() {
		 Consola.mostrarCabecera("Selecciono borrar turismo");
	        try {
	            controlador.borrar(Consola.leerTurismo());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	private void borrarAlquiler() {
		 Consola.mostrarCabecera("Selecciono borrar alquiler");
	        try {
	            controlador.borrar(Consola.leerAlquiler());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	private void listarClientes() {
		 Consola.mostrarCabecera("Selecciono listar clientes");
	        try {
	            controlador.getClientes();
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}

	private void listarTurismos() {
		 Consola.mostrarCabecera("Selecciono listar turismos");
	        try {
	            controlador.getTurismos();
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
    
	private void listarAlquileres() {
		 Consola.mostrarCabecera("Selecciono listar alquileres");
	        try {
	            controlador.getAlquileres();
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
	}
 
	private void listarAlquileresCliente() {
		 Consola.mostrarCabecera("Selecciono listar alquileres cliente");
	        try {
	            controlador.getAlquileres(Consola.leerClienteDni());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
  
	private void listarAlquileresTurismo() {
		 Consola.mostrarCabecera("Selecciono listar alquileres turismo");
	        try {
	            controlador.getAlquileres(Consola.leerTurismoMatricula());
	        } catch (OperationNotSupportedException | NullPointerException | IllegalArgumentException e) {
	            System.out.println(e.getMessage());
	        }
		
	}
	
}