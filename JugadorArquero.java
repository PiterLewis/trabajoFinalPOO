package com.utad.poo.proyectofinaldefinitivo;

public  class JugadorArquero extends Jugador {

	 public JugadorArquero(String nombre, Integer ataque, String habilidadEspecial, Integer vidaInicial){
	        super(nombre, ataque, habilidadEspecial, vidaInicial);
	    }

	    @Override
	    public Integer calcularDanio() {
	        Integer danioBase = super.calcularDanio();
	        return danioBase; // Se calcula el daño base con cualquier arma
	    }
		
}
