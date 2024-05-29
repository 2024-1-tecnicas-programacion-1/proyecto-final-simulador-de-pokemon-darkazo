package simulador.pokemon;

public abstract class Pokemon implements Combatiente{
    
    private String nombrePokemon;
    private int salud;
    private int puntosDeAtaque;
    private TipoPokemon tipo;
    private Estado estado;

    public Pokemon(String nombrePokemon, int salud, int puntosDeAtaque, TipoPokemon tipo, Estado estado) {
        this.nombrePokemon = nombrePokemon;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = Estado.Normal;
    }//Cierre constructor
    
    @Override
    public String getNombre() {
        return nombrePokemon;
    }
    
    @Override
    public int getSalud() {
        return salud;
    }
    
    public boolean estaVivo(){
        return salud > 0;
    }
    
    @Override
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

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public abstract void atacar(Combatiente oponentPokemon);
    
    public int recibirDaño(int daño){
        int nuevaSalud=this.salud - daño;
        this.setSalud(nuevaSalud);
        System.out.println(this.getNombre()+" recibe "+daño+" puntos de daño. Salud restante: "+nuevaSalud);
        return nuevaSalud;
    }
    
    public void entrenar(){
        this.puntosDeAtaque += 10;
        this.salud +=20;
    }
}//Cierre class
