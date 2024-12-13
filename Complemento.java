package com.utad.poo.proyectofinaldefinitivo;

public abstract class Complemento {
	
	protected String tipo;

	 public Complemento(String tipo) {
	        this.tipo = tipo;
	    }

	    public String getTipo() {
	        return tipo;
	    }

		@Override
		public String toString() {
			return "Complemento [tipo=" + tipo + "]";
		}
}
