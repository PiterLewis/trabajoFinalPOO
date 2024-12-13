package com.utad.poo.proyectofinaldefinitivo;

//Clase base Jugador
public abstract class Jugador {

	    protected String nombre;
	    protected Integer vidaInicial;
	    protected Integer vidaActual;
	    protected Integer ataque;
	    protected String habilidadEspecial;
	    protected Arma armaActual;
	    protected Complemento complementoActual;

	    public Jugador(String nombre, Integer ataque, String habilidadEspecial, Integer vidaInicial) {
	        this.nombre = nombre;
	        this.vidaInicial = vidaInicial;
	        this.vidaActual = vidaInicial; // Inicializamos la vida actual con vidaInicial
	        this.ataque = ataque;
	        this.habilidadEspecial = habilidadEspecial;
	    }

	    public void mover(Integer dx, Integer dy, Mapa mapa) {
	        System.out.println(nombre + " se mueve a una nueva posición.");
	    }

	    public void recogerArma(Arma arma) {
	        this.armaActual = arma;
	        System.out.println(nombre + " ha recogido el arma: " + arma.getTipo());
	    }

	    public void recogerComplemento(Complemento complemento) {
	        this.complementoActual = complemento;
	        System.out.println(nombre + " ha recogido el complemento: " + complemento.getTipo());
	    }

	    public void atacar(Jugador enemigo) {
	        if (enemigo == null) {
	            System.out.println(nombre + " no tiene un enemigo adyacente para atacar.");
	            return;
	        }
	        Integer danioBase = calcularDanio();
	        Integer danio = Math.max(0, danioBase);  // El daño no puede ser negativo
	        enemigo.setVidaActual(enemigo.getVidaActual() - danio); // Restamos vida 
	        System.out.println(nombre + " ataca a " + enemigo.nombre + " causando " + danio + " de daño.");
	    }

	    public abstract void usarHabilidad();

	    public Integer calcularDanio() {
	        Integer danioBase = ataque;
	        if (armaActual != null) {
	            danioBase += armaActual.getDanio();
	        }
	        return danioBase;
	    }

	    public boolean estaVivo() {
	        return vidaActual > 0;
	    }
	    
	    public String getNombre() {
			return nombre;
		}

		public Integer getVidaInicial() {
			return vidaInicial;
		}

		public void setVidaInicial(Integer vidaInicial) {
			this.vidaInicial = vidaInicial;
		}

		public Integer getVidaActual() {
	        return vidaActual;
	    }

	    public void setVidaActual(Integer vidaActual) {
	        if (vidaActual > vidaInicial) {
	            this.vidaActual = vidaInicial;
	        } else if (vidaActual < 0) {
	            this.vidaActual = 0; // Aseguramos que la vida no sea negativa
	        } else {
	            this.vidaActual = vidaActual;
	        }
	    }

	    @Override
	    public String toString() {
	        return nombre + " (Vida: " + vidaActual + ", Ataque: " + ataque + ")";
	    }
	}

