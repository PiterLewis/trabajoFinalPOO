package com.utad.poo.proyectofinaldefinitivo;

public class ComplementoCura extends Complemento {
	// Constructor
    public ComplementoCura(String tipo) {
        super(tipo);
    }

    // Método para curar al jugador
    public void curar(Jugador jugador) {
        int vidaCurada = 50;

        // Comprobamos que el jugador no tenga la vida al máximo
        if (jugador.getVidaActual() == jugador.getVidaInicial()) {
            System.out.println(jugador.getNombre() + " ya tiene la vida al máximo y no puede curarse más.");
            return;
        }

        // Calculamos cuánta vida puede recuperar sin superar la vida máxima
        int vidaRestante = jugador.getVidaInicial() - jugador.getVidaActual();
        int vidaARecuperar = Math.min(vidaCurada, vidaRestante);

        // Recuperamos la vida
        jugador.setVidaActual(jugador.getVidaActual() + vidaARecuperar);
        System.out.println(jugador.getNombre() + " se ha curado " + vidaARecuperar + " puntos de vida. Vida actual: " + jugador.getVidaActual());
    }
    
}
