class Medico extends Jugador {
    public Medico(String nombre, Integer[] posicion) {
        super(nombre, 120, posicion, "Médico");
    }

    public void usarHabilidad() {
		if (vidaActual < vidaInicial && !habilidadEspecial) {
	            int curacion = 50;
	            int nuevaVida = Math.min(vidaActual + curacion, vidaInicial);
	            setVidaActual(nuevaVida);
	            habilidadEspecial = true;
	            System.out.println(nombre + " se ha curado a " + nuevaVida + " puntos de vida.");
		}
	}
}
