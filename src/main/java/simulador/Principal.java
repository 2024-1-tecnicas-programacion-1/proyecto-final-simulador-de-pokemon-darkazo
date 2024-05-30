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

import simulador.pokemon.Estado;
import simulador.pokemon.Vulpix;
import simulador.pokemon.Poliwag;
import simulador.pokemon.Oddish;
import simulador.pokemon.Magnemite;
import simulador.pokemon.Drowzee;
import simulador.pokemon.Rhyhorn;
import simulador.pokemon.Spearow;
import simulador.pokemon.Meowth;
import simulador.pokemon.Mankey;
import simulador.pokemon.Koffing;
import simulador.pokemon.NuevoPokemon;

public class Principal {
    
    private static LinkedList<Entrenador> entrenadores = new LinkedList<>();
    private static LinkedList<Pokemon> pokemonesRegistrados = new LinkedList<>();
    private static Entrenador entrenador1;
    private static Entrenador entrenador2;
    private static Pokemon pokemon1;
    private static Pokemon pokemon2;
    private static Pokemon[] pokemonesPredefinidos = {
        new Vulpix(), 
        new Poliwag(), 
        new Oddish(), 
        new Magnemite(), 
        new Drowzee(), 
        new Rhyhorn(), 
        new Spearow(), 
        new Meowth(), 
        new Mankey(), 
        new Koffing()
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("* Simulador de Batallas Pokémon DarKaZo *");
            System.out.println("");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println("");
            sc.nextLine();

            switch (opcion) {
                case 1:
                    gestionarEntrenadores(sc);
                    break;
                case 2:
                    gestionarPokemones(sc);
                    break;

                case 3:
                    iniciarBatalla(sc);
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
            System.out.println("");
            System.out.println("Gestionar Entrenadores");
            System.out.println("");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println("");
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
            System.out.println("");
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a Gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println("");
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
    
     private static void gestionarPokemones(Scanner sc) {
        int opcion;
        do {
            System.out.println("Gestionar Pokemones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println("");
            sc.nextLine();

            switch (opcion) {
                case 1:
                    verPokemonesRegistrados();
                    break;
                case 2:
                     registrarNuevoPokemon(sc);
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 3);
     }//Cierre gestionarPokemones
     
     private static void verPokemonesRegistrados() {
        System.out.println("Pokémones Registrados:");
        for (int i = 0; i < pokemonesPredefinidos.length; i++) {
            Pokemon pokemon = pokemonesPredefinidos[i];
            System.out.println((i + 1) + ". " + pokemon.getNombre()+ " (salud: " + pokemon.getSalud()+", Ataque: " + pokemon.getPuntosDeAtaque() + ", Tipo: " + pokemon.getTipo()+")");    
        }
         System.out.println("");
        
         System.out.println("Lista De Nuevos Pokemones");
        for (int i = 0; i < pokemonesRegistrados.size(); i++) {
            Pokemon pokemon = pokemonesRegistrados.get(i);
            System.out.println((i + 1) + ". " + pokemon.getNombre()+ " (salud: " + pokemon.getSalud()+", Ataque: " + pokemon.getPuntosDeAtaque() + ", Tipo: " + pokemon.getTipo()+")");    
        }
        System.out.println("");

    }//Cierre verPokemonesRegistrados
     
     public static void registrarNuevoPokemon(Scanner sc) {
        System.out.println("Registrar nuevo Pokémon:");
        System.out.print("Ingrese el nombre del nuevo Pokémon: ");
        String nombre = sc.nextLine();
         System.out.println("");
        
        for (int i = 0; i < pokemonesRegistrados.size(); i++) {
            Pokemon pokemon = pokemonesRegistrados.get(i);
            if (pokemon.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("¡El Pokémon " + nombre + " ya está registrado!");
                System.out.println("");
            }
        }

        System.out.print("Ingrese la salud del nuevo Pokémon: ");
        int salud = sc.nextInt();
        System.out.print("Ingrese los puntos de ataque del nuevo Pokémon: ");
        int puntosDeAtaque = sc.nextInt();
        System.out.print("Ingrese el tipo del nuevo Pokémon (FUEGO, AGUA, PLANTA, etc.): ");
        String tiposInput = sc.nextLine();
        List<TipoPokemon> tipos = new ArrayList<>();
        boolean tiposValidos = true;
        
        for (String tipo : tiposInput.split(",")) {
            try {
                tipos.add(TipoPokemon.valueOf(tipo.trim().toUpperCase()));
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo de Pokémon inválido: " + tipo.trim());
                tiposValidos = false;
                break;
            }
        }

        if (!tiposValidos) {
            System.out.println("Registro cancelado debido a tipos inválidos.");
            return; // Salir del método si algún tipo no es válido
        }
        Estado estado = Estado.NORMAL;
        
        System.out.println("¡Nuevo Pokémon registrado exitosamente!");

        pokemonesRegistrados.add(new NuevoPokemon(nombre, salud, puntosDeAtaque, tipos, estado));
    }//Cierre registrarNuevoPokemon
        
     
     
    private static void iniciarBatalla(Scanner sc) {
        int opcion;
        do {
            System.out.println("Gestionar Pokemones");
            System.out.println("1. Elegir entrenador 1");
            System.out.println("2. Elegir entrenador 2");
            System.out.println("3. Seleccionar Pokémon de entrenador 1");
            System.out.println("4. Seleccionar Pokémon de entrenador 2");
            System.out.println("5. Comenzar batalla");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            System.out.println("");
            sc.nextLine();

            switch (opcion) {
                case 1:
                    verListaEntrenadores();
                    System.out.print("Selecciona el número del primer entrenador: ");
                    int indiceEntrenador1 = sc.nextInt() - 1;
                    if (indiceEntrenador1 >= 0 && indiceEntrenador1 < entrenadores.size()) {
                        entrenador1 = entrenadores.get(indiceEntrenador1);
                        System.out.println("Entrenador 1 seleccionado: " + entrenador1.getNombreEntrenador());
                    } else {
                        System.out.println("Índice inválido");
                    }
                    break;
                case 2:
                    verListaEntrenadores();
                    System.out.print("Selecciona el número del segundo entrenador: ");
                    int indiceEntrenador2 = sc.nextInt() - 1;
                    if (indiceEntrenador2 >= 0 && indiceEntrenador2 < entrenadores.size()) {
                        entrenador2 = entrenadores.get(indiceEntrenador2);
                        System.out.println("Entrenador 1 seleccionado: " + entrenador2.getNombreEntrenador());
                    } else {
                        System.out.println("Índice inválido");
                    }
                    break;
                case 3:
                    if (entrenador1 != null) {
                        System.out.println("Seleccionando Pokémon para el entrenador " + entrenador1.getNombreEntrenador());
                        entrenador1.mostrarPokemones();
                        System.out.print("Selecciona el número del Pokémon: ");
                        int indicePokemon1 = sc.nextInt() - 1;
                        if (indicePokemon1 >= 0 && indicePokemon1 < entrenador1.getPokemones().size()) {
                            pokemon1 = entrenador1.getPokemones().get(indicePokemon1);
                            System.out.println("Pokémon seleccionado para el entrenador 1: " + pokemon1.getNombre());
                        } else {
                            System.out.println("Índice inválido");
                        }
                    } else {
                        System.out.println("Debes seleccionar el entrenador 1 primero");
                    }
                    break;
                case 4:
                    if (entrenador2 != null) {
                        System.out.println("Seleccionando Pokémon para el entrenador " + entrenador2.getNombreEntrenador());
                        entrenador2.mostrarPokemones();
                        System.out.print("Selecciona el número del Pokémon: ");
                        int indicePokemon2 = sc.nextInt() - 1;
                        if (indicePokemon2 >= 0 && indicePokemon2 < entrenador2.getPokemones().size()) {
                            pokemon2 = entrenador2.getPokemones().get(indicePokemon2);
                            System.out.println("Pokémon seleccionado para el entrenador 2: " + pokemon2.getNombre());
                        } else {
                            System.out.println("Índice inválido");
                        }
                    } else {
                        System.out.println("Debes seleccionar el entrenador 2 primero");
                    } 
                    break;
                case 5:
                     if (pokemon1 != null && pokemon2 != null) {
                        Batalla batalla = new Batalla();
                        batalla.iniciarBatalla(pokemon1, pokemon2);
                    } else {
                        System.out.println("Debes seleccionar un Pokémon para cada entrenador antes de comenzar la batalla");
                    }
                    break;
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción inválida");
                    break;
            }
        } while (opcion != 6);
     }//Cierre iniciarBatalla
        
}//Cierre class
