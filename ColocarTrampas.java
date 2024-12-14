// Subclase de objeto: Trampa
class Trampa extends Objeto {
    private Integer dano;

    public Trampa(Integer[] posicion, Integer dano) {
        super("Trampa", posicion);
        this.dano = dano;
    }

    @Override
    public void usar(Entidad entidad) {
        entidad.recibirDano(dano);
        System.out.println("Trampa activada en " + posicion[0] + "," + posicion[1] + ".");
    }

    public Integer getDano() {
        return dano;
    }
}
