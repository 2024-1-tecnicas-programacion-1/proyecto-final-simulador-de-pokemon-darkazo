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

    public String getNombrePokemon() {
        return nombrePokemon;
    }

    public int getSalud() {
        return salud;
    }

    public int getPuntosDeAtaque() {
        return puntosDeAtaque;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public String getEstado() {
        return estado;
    }
    
    
    
    
    public abstract void atacar(Pokemon oponentPokemon);
    
    public abstract int recibirDaño(int daño);
    
    public abstract void entrenar();
}//Cierre class
