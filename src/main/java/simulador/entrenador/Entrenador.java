package simulador.entrenador;

import java.util.LinkedList;
import simulador.pokemon.Pokemon;

class Entrenador extends Pokemon{
    
    private String nombreEntrenador;
    private LinkedList<Pokemon> Pokemones;

    public Entrenador(String nombreEntrenador, LinkedList<Pokemon> Pokemones) {
        super(nombrePokemon, tipo);
        this.nombreEntrenador = nombreEntrenador;
        this.Pokemones = Pokemones;
    }

    

    
    
    
    
}//Cierre class
