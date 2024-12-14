public class TableroConsola extends Tablero {
    public TableroConsola(Mapa mapa) {
        super(mapa);
    }
    
    public void mostrarTablero() {
        for (int i = 0; i < mapa.getAlto(); i++) {
            for (int j = 0; j < mapa.getAncho(); j++) {
                if (mapa.getPosicion(i, j) == null) {
                    System.out.print(" ");
                } else {
                    System.out.print(mapa.getPosicion(i, j).getSimbolo());
                }
            }
            System.out.println();
        }
    }

}
