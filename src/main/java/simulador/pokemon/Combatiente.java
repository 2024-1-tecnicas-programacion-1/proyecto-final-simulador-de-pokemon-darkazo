package simulador.pokemon;

import java.util.List;

public interface Combatiente {

    void atacar(Combatiente oponente);

    boolean estaVivo();

    String getNombre();

    int getSalud();

    void setSalud(int salud);
    
    List<TipoPokemon> getTipo();

    void recibirDaño(int daño);
}
