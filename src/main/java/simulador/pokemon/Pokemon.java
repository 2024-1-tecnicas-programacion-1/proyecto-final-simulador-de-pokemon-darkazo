package simulador.pokemon;

public abstract class Pokemon {
    
    private String nombrePokemon;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private String estado;

    public Pokemon(String nombrePokemon, int salud, int puntosDeAtaque, TipoPokemon tipo, String estado) {
        this.nombrePokemon = nombrePokemon;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = estado;
    }//Cierre constructor

    public String getNombre() {
        return nombrePokemon;
    }

    public void setNombre(String nombrePokemon) {
        this.nombrePokemon = nombrePokemon;
    }
  
    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = salud;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public void setPuntosDeAtaque(int puntosDeAtaque) {
        this.puntosDeAtaque = puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public void setTipo(TipoPokemon tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public abstract void atacar(Pokemon oponentPokemon);
    
    public abstract int recibirDaño(int daño);
    
    public abstract void entrenar();
}//Cierre class
