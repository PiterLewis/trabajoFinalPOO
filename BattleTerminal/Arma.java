package BattleTerminal;

public class Arma implements Modificable{
    private String nombre;
    private String tipo;
    private int dano;
    private String descripcion;  // Descripción opcional del arma

    public Arma(String nombre, String tipo, int dano, String descripcion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.dano = dano;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getDano() {
        return dano;
    }

    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String toString() {
        return nombre + " (" + tipo + "), Daño: " + dano;
    }

    @Override
    public Boolean comprobarModificacion(){
        // si el daño del arma es menor a 90, se puede modificar
        return this.dano < 90;

    }

    @Override
    public void modificar() {
        if (comprobarModificacion()) {
            this.dano += 10; // Incrementamos el daño como ejemplo
            System.out.println(nombre + " ha sido mejorada. Daño ahora: " + dano);
        } else {
            System.out.println("No se puede modificar el arma " + nombre);
        }
    }
}
