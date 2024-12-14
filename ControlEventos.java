public class ControlEventos {
    private Tablero tablero;
    private PanelJuego panelJuego;
    private PanelJugador panelJugador;
    private Mapa mapa;
    
    public ControlEventos(Tablero tablero, PanelJuego panelJuego, PanelJugador panelJugador, Mapa mapa) {
        this.tablero = tablero;
        this.panelJuego = panelJuego;
        this.panelJugador = panelJugador;
        this.mapa = mapa;
    }
    
    public void moverJugador(int x, int y) {
        panelJugador.moverJugador(x, y);
    }
    
    public void moverJugador(int x, int y, int x2, int y2) {
        panelJugador.moverJugador(x, y, x2, y2);
    }
    
    public void moverJugador(int x, int y, int x2, int y2, int x3, int y3) {
        panelJugador.moverJugador(x, y, x2, y2, x3, y3);
    }
    
    public void moverJugador(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4) {
        panelJugador.moverJugador(x, y, x2, y2, x3, y3, x4, y4);
    }
    
    public void moverJugador(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5) {
        panelJugador.moverJugador(x, y, x2, y2, x3, y3, x4, y4, x5, y5);
    }
    
    public void moverJugador(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6) {
        panelJugador.moverJugador(x, y, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6);
    }
    
    public void moverJugador(int x, int y, int x2, int y2, int x3, int y3, int x4, int y4, int x5, int y5, int x6, int y6, int x7, int y7) {
        panelJugador.moverJugador(x, y, x2, y2, x3, y3, x4, y4, x5, y5, x6, y6, x7, y7);
    }
}
