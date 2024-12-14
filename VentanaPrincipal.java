public class VentanaPrincipal extends TableroGrafico{
    //Atributos
    private Mapa mapa;
    private Soldado soldado;
    private Objeto objeto;
    
    //Constructor
    public VentanaPrincipal(){
        mapa = new Mapa();
        soldado = new Soldado();
        objeto = new Objeto();
    }
    
    //Metodos
    public void mostrar(){
        System.out.println("Ventana Principal");
    }
    
    public static void main(String[] args){
        VentanaPrincipal ventana = new VentanaPrincipal();
        ventana.mostrar();
    }

}
