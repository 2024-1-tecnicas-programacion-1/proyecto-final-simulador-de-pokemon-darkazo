package simulador.pokemon;

public interface Combatiente {

    void atacar(Combatiente pokemonOponent);

    boolean estaVivo();

    String getNombre();

    int getSalud();

    void setSalud(int salud);
}
