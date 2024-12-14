public class TableroGrafico extends Tablero{

    //Tablero hecho con y con JFrame
    public TableroGrafico(Mapa mapa) {
        super(mapa);
    }

    public void mostrarTablero() {
        JFrame frame = new JFrame();
        frame.setSize(800, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setLayout(new GridLayout(mapa.getAlto(), mapa.getAncho()));
        for (int i = 0; i < mapa.getAlto(); i++) {
            for (int j = 0; j < mapa.getAncho(); j++) {
                if (mapa.getPosicion(i, j) == null) {
                    frame.add(new JLabel(" "));
                } else {
                    frame.add(new JLabel(mapa.getPosicion(i, j).getSimbolo()));
                }
            }
        }
    }

}
