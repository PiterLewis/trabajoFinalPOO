// Clase Trampa que hereda de Objeto
class Trampa extends Objeto {
    private int dano;

    public Trampa(Integer[] posicion, int dano) {
        super("Trampa", posicion);
        this.dano = dano;
    }

    @Override
    public void usar(Entidad entidad) {
        entidad.recibirDano(dano);
        System.out.println("Trampa activada en " + posicion[0] + "," + posicion[1] + ".");
    }

    public int getDano() {
        return dano;
    }
}
