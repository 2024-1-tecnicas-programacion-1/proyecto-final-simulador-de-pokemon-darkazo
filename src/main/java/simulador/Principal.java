package simulador;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import simulador.batalla.Batalla;
import simulador.entrenador.Entrenador;
import simulador.pokemon.Vulpix;

public class Principal {
    
    private static LinkedList<Entrenador> entrenadores = new LinkedList<>();
    private static LinkedList<Pokemon> pokemonesRegistrados = new LinkedList<>();
    private static Entrenador entrenador1;
    private static Entrenador entrenador2;
    private static Pokemon pokemon1;
    private static Pokemon pokemon2;
    private static final Pokemon[] pokemonesPredefinidos = {new Vulpix()};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("*** Simulador de Batallas Pokémon DarKaZo ***");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestionarEntrenadores(sc);
                    break;
                case 2:

                    break;

                case 3:

                    break;

                case 4:

                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 4);
    }//Main

    private static void gestionarEntrenadores(Scanner sc) {
        int opcion;
        String nombre;
        do {
            System.out.println("Gestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Introduce el nombre del nuevo entrenador: ");
                    nombre = sc.nextLine();
                    entrenadores.add(new Entrenador(nombre, new LinkedList<>()));
                    System.out.println("Entrenador registrado: " + nombre);
                    break;
                case 2:
                    System.out.println("Lista de Entrenadores:");
                    for (int i = 0; i < entrenadores.size(); i++) {
                        System.out.println((i + 1) + ". " + entrenadores.get(i).getNombreEntrenador());
                    }
                    break;

                case 3:
                    verListaEntrenadores();
                    System.out.print("Selecciona el número del entrenador: ");
                    int indice = sc.nextInt() - 1;
                    if (indice >= 0 && indice < entrenadores.size()) {
                        gestionarEntrenadorSeleccionado(sc, entrenadores.get(indice));
                    } else {
                        System.out.println("Índice inválido");
                    }
                    break;

                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        } while (opcion != 4);

    }//Gestionar Entrenadores

    private static void verListaEntrenadores() {
        System.out.println("Lista de Entrenadores:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombreEntrenador());
        }
    }//Cierre VerEntrenadores
    
    public static void gestionarEntrenadorSeleccionado(Scanner sc, Entrenador entrenador) {
        int opcion;
        do {
            System.out.println("Gestionando a " + entrenador.getNombreEntrenador());
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    entrenador.mostrarPokemones();
                    break;
                case 2:
                    agregarPokemonAlEquipo(sc, entrenador);
                    break;
                case 3:
                    entrenarPokemon(sc, entrenador);
                    break;
                case 4:
                    System.out.println("Volviendo a gestionar entrenadores...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 4);
    }//Cierre gestionar entrenadores
    
    public static void agregarPokemonAlEquipo(Scanner sc, Entrenador entrenador){
        System.out.println("Es momento de atrapar un nuevo Pokemon a tu equipo " + entrenador.getNombreEntrenador());
        for (int i = 0; i < pokemonesPredefinidos.length; i++) {
            Pokemon pokemon = pokemonesPredefinidos[i];
            System.out.println((i+1)+"." + pokemon.getNombre() + " (salud: " + pokemon.getSalud()+", Ataque: " + pokemon.getPuntosDeAtaque() + ", Tipo: " + pokemon.getTipo()+")");
        }//Cierre for
        
        int indice = sc.nextInt()-1;
        if(indice >=0 && indice<pokemonesPredefinidos.length){
            entrenador.agregarPokemon(pokemonesPredefinidos[indice]);
        }else{
            System.out.println("Indice no valido");
        }
    }//Cierre agregarPokemon
    
    public static void entrenarPokemon(Scanner sc, Entrenador entrenador){
        System.out.println("Entrenar Pokemones:");
        entrenador.mostrarPokemones();
        System.out.println("Seleccione un Pokemon para entrenar");
        int indice = sc.nextInt();
        if(indice>=0 && indice < entrenador.getPokemones().size()){
            Pokemon pokemones = entrenador.getPokemones().get(indice);
        }else{
            System.out.println("Ese Pokemon no esta en tu Equipo");
        }
    }//Cierre entrenarPokemon
        
}//Cierre class
