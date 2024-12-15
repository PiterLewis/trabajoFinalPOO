class Ingeniero extends Jugador {
    public Ingeniero(String nombre, Integer[] posicion) {
        super(nombre, 110, posicion, "Ingeniero");
    }
     public void usarHabilidad() {
        // El Ingeniero puede colocar una trampa en una casilla adyacente
		colocarTrampa(posX, posY);
		System.out.println(nombre + " ha activado su habilidad para colocar una trampa.");
    }

    // Método para colocar la trampa en una casilla adyacente
    public void colocarTrampa(int x, int y) {
        if (esCasillaAdyacente(x, y)) {
            mapa.colocarTrampa(x, y);  // Coloca la trampa en el mapa y cambia el color de la casilla a rojo
            System.out.println(nombre + " ha colocado una trampa en la casilla (" + x + "," + y + ")");
        } else {
            System.out.println("La casilla seleccionada no es adyacente.");
        }
    }

    // Verifica si la casilla es adyacente al Ingeniero
    public boolean esCasillaAdyacente(int x, int y) {
        // Compara las coordenadas de la casilla seleccionada con la posición del Ingeniero
        return Math.abs(x - this.posX) <= 1 && Math.abs(y - this.posY) <= 1;
    }
}
