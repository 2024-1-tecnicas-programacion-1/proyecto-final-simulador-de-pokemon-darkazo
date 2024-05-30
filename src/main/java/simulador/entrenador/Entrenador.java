package simulador.entrenador;
import java.util.LinkedList;
import simulador.pokemon.Pokemon;

public class Entrenador{
    
    private String nombreEntrenador;
    private LinkedList<Pokemon> Pokemones;

    public Entrenador(String nombreEntrenador, LinkedList<Pokemon> Pokemones) {
        this.nombreEntrenador = nombreEntrenador;
        this.Pokemones = Pokemones;
    }
    
// agregarPokemon
// Complejidad temporal: O(1) Tiempo constante.

    public void agregarPokemon(Pokemon pokemon) {
        if (Pokemones.size() < 6) {
            Pokemones.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido añadido al equipo de " + nombreEntrenador);
        } else {
            System.out.println("El equipo ya está completo. No puedes añadir otro Pokémon.");
        }
    }

// entrenarPokemon
// Complejidad temporal: O(1) Tiempo constante.

    public void entrenarPokemon(Pokemon pokemon) {
        if (Pokemones.contains(pokemon)) {
            pokemon.entrenar();
            System.out.println(pokemon.getNombre() + " ha sido entrenado!");
        } else {
            System.out.println("Pokemon no encontrado en el equipo");
        }
    }

// mostrarPokemones
// Complejidad temporal: O(N) Tiempo lineal.
    
    public void mostrarPokemones() {
        System.out.println("Pokémones de " + nombreEntrenador + ":");
        for (int i = 0; i < Pokemones.size(); i++) {
            System.out.println(i + ":" + Pokemones.get(i));
        }
    }

// prepararBatalla
// Complejidad temporal: O(N) Tiempo lineal.
    
    public void prepararBatalla(Pokemon pokemonSeleccionado) {
        if (Pokemones.contains(pokemonSeleccionado)) {
            System.out.println("POKÉMON SELECCIONADO");
            System.out.println("Nombre: " + pokemonSeleccionado.getNombre());
            System.out.println("Salud: " + pokemonSeleccionado.getSalud());
            System.out.println("Puntos de Ataque: " + pokemonSeleccionado.getPuntosDeAtaque());
            System.out.println("Tipo: " + pokemonSeleccionado.getTipo());
            System.out.println("Estado: " + pokemonSeleccionado.getEstado());
            // Puedes agregar más información si es necesario
        } else {
            System.out.println("El Pokémon seleccionado no pertenece a este entrenador.");
        }
    }

    public String getNombreEntrenador() {
        return nombreEntrenador;
    }

    public LinkedList<Pokemon> getPokemones() {
        return Pokemones;
    }

    public void setNombreEntrenador(String nombreEntrenador) {
        this.nombreEntrenador = nombreEntrenador;
    }

    public void setPokemones(LinkedList<Pokemon> Pokemones) {
        this.Pokemones = Pokemones;
    }
    
    @Override
    public String toString() {
        return "Entrenador{" + "nombreEntrenador=" + nombreEntrenador + ", pokemones=" + Pokemones + '}';
    }

}//Cierre class
