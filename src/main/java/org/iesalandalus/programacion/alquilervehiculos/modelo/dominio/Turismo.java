package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo extends Vehiculo {
	private static final int FACTOR_CILINDRADA = 10;
	private int cilindrada;
	
	
	public Turismo (String marca,String modelo,int cilindrada,String matricula) {
	super(marca,modelo,matricula);
		
		setCilindrada(cilindrada);
		
	}
	public Turismo (Turismo turismo) {
		super(turismo.getMarca(),turismo.getModelo(),turismo.getMatricula());
		setCilindrada(turismo.getCilindrada());
		
		
	}
	public static Turismo getTurismoConMatricula(String matricula) {
		return new Turismo("Ford", "Focus", 1400, matricula);
	}


	@Override
	public String toString() {
		return   getMarca() +" "+ getModelo() + " (" + cilindrada + "CV) - "
				+ getMatricula() ;
	}
	@Override
	public int hashCode() {
		return Objects.hash(getMatricula());
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
		return Objects.equals(getMatricula(), other.getMatricula());
	}


	public int getCilindrada() {
		return cilindrada;
	}

	private void setCilindrada(int cilindrada) {
		if (cilindrada<=0 ||cilindrada>5000)
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		this.cilindrada = cilindrada;
	}



	@Override
	protected int getFactorPrecio() {
		
		return getCilindrada()/FACTOR_CILINDRADA;
	}
	
}
