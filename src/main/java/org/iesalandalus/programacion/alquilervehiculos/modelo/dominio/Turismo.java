package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {
	private String ER_MARCA= "^[a-zA-Z0-9]{3,20}([\\s-][a-zA-Z0-9]+)*$";
	private String ER_MATRICULA= "[0-9]{4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
	
	public Turismo (String marca,String modelo,int cilindrada,String matricula) {
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
	}
	public Turismo (Turismo turismo) {
		if (turismo == null)
		throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		setMarca(turismo.marca);
		setModelo(turismo.modelo);
		setCilindrada(turismo.cilindrada);
		setMatricula(turismo.matricula);
		
	}
	public static Turismo getTurismoConMatricula(String matricula) {
		return new Turismo("Ford", "Focus", 1600, matricula);
	}

	public String getMarca() {
		return marca;
	}

	@Override
	public String toString() {
		return   marca +" "+ modelo + " (" + cilindrada + "CV) - "
				+ matricula ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}
	private void setMarca(String marca) throws IllegalArgumentException {
		if (marca!=null)
			this.marca = marca;
		else 
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		if ( !marca.matches(ER_MARCA)||marca.isEmpty()||marca.isBlank())
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		
	}

	public String getModelo() {
		return modelo;
	}

	private void setModelo(String modelo) throws IllegalArgumentException{
		if (modelo!=null)
			this.modelo = modelo;
		else 
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		if (modelo.isEmpty() || modelo.isBlank())
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		
	}

	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada<=0 ||cilindrada>5000)
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		this.cilindrada = cilindrada;
	}

	public String getMatricula() {
		return matricula;
	}

	private void setMatricula(String matricula) {
		if (matricula!=null)
			this.matricula = matricula;
		else 
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		if ( !matricula.matches(ER_MATRICULA))
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
	}
	
}
