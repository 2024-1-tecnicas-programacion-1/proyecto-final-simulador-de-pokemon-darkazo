package simulador.pokemon;

import java.util.List;

public abstract class Pokemon implements Combatiente {

    private String nombrePokemon;
    private int salud;
    private int puntosDeAtaque;
    private List<TipoPokemon> tipo;
    private Estado estado;

    public Pokemon(String nombrePokemon, int salud, int puntosDeAtaque, List<String> tipos, Estado estado) {
        this.nombrePokemon = nombrePokemon;
        this.salud = salud;
        this.puntosDeAtaque = puntosDeAtaque;
        this.tipo = tipo;
        this.estado = Estado.NORMAL;
    }

    @Override
    public String getNombre() {
        return nombrePokemon;
    }

    @Override
    public int getSalud() {
        return salud;
    }

    @Override
    public boolean estaVivo() {
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

    @Override
    public List<TipoPokemon> getTipo() {
        return tipo;
    }

    public void setTipo(List<TipoPokemon> tipos) {
        this.tipo = tipo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estado getEstado() {
        return estado;
    }

    
    @Override
    public abstract void atacar(Combatiente oponente);

    public abstract void recibirDaño(int daño);

    public void entrenar() {
        this.puntosDeAtaque += 10;
        this.salud += 20;
    }
}

