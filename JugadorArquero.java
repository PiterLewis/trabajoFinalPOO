package com.utad.poo.proyectofinaldefinitivo;

public  class JugadorArquero extends Jugador {

	 public JugadorArquero(String nombre, Integer ataque, String habilidadEspecial, Integer vidaInicial){
	        super(nombre, ataque, habilidadEspecial, vidaInicial);
	    }

	    @Override
	    public Integer calcularDaño() {
	        Integer daniooBase = super.calcularDaño();
	        return dañoBase; // Se calcula el daño base con cualquier arma
	    }
		
}
