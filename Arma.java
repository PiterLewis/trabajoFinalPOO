package com.utad.poo.proyectofinaldefinitivo;

public abstract class Arma {
    protected String tipo;
    protected Integer daño;

   public Arma(String tipo, Integer daño) {
        this.tipo = tipo;
        this.daño = daño;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getDaño() {
        return daño;
    }

    @Override
    public String toString() {
        return tipo + " (Daño: " + daño + ")";
    }

	
}
