package com.utad.poo.proyectofinaldefinitivo;

public class ArmaFrancotirador extends Arma {

	    public ArmaFrancotirador(String tipo, Integer danio) {
	        super(tipo, daño);
	    }

	    // Método corregido
	    public void atacarYMover(Jugador atacante, Jugador objetivo, Integer dx, Integer dy, Mapa mapa) {
	        if (objetivo != null) {
	            Integer danio = getDaño(); // Obtenemos el daño de la arma

	            // Si el atacante es un arquero, aumenta el daño en un 20%
	            if (atacante instanceof JugadorArquero) {
	                danio += (int) (getDanio() * 0.2); // Incremento del 20% si el atacante es Arquero
	            }

	            // Aplicamos el daño al objetivo
	            objetivo.setVidaActual(objetivo.getVidaActual() - danio);
	            System.out.println(atacante.nombre + " ataca a " + objetivo.nombre + " con el Rifle de francotirador causando " + daño + " de daño.");
	        }
	        atacante.mover(dx, dy, mapa);  // El atacante se mueve después de atacar
	        System.out.println(atacante.nombre + " se mueve después del ataque.");
	    }
	}


