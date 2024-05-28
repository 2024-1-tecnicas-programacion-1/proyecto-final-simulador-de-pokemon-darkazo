package simulador;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import simulador.batalla.Batalla;

public class Principal {
    
    Scanner sc = new Scanner(System.in);
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Batalla batalla= new Batalla();
        
    public void menuPrincipal(){     
       
        int opcion;
        do{
            System.out.println("***Simulador de Batallas Pokemon***");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokemones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = sc.nextInt();
            
            switch (opcion){
                case 1: 
                    menuEntrenadores();
                    break; 
                case 2:
                    menuPokemones();
                    break;
                case 3:
                    menuBatalla();
                    break;
                case 4:
                    System.out.println("Saliendo del simulador...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion!=4);
    }    
    
    private void menuEntrenadores(){
    
        int opcion;
        do{
            System.out.println("Gestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion=sc.nextInt();
            
            switch (opcion){
                case 1:
                    registarEntrenadores();
                    break;
                case 2:
                    listaEntrenadores();
                    break;
                case 3:
                    seleccionarEntrenador();
                    break;
                case 4:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion !=4);
    }
    
    private void registarEntrenadores(){
        System.out.println("Introduce el nombre del nuevo entrenador: ");
        String nombre= sc.next();
        entrenadores.add(new Entrenador(nombre));
        System.out.println("Entrenador "+nombre+" registrado con éxito.");
    }

    private void listaEntrenadores(){
        if (entrenadores.isEmpty()){
            System.out.println("No hay entrenadores registrados.");
        }else{
            System.out.println("Lista de entrenadores: ");
            for(Entrenador entrenador : entrenadores){
                System.out.println(entrenador);
            }
        }
    }
    
    private void seleccionarEntrenador(){
        if (entrenadores.isEmpty()){
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("Selecciona un entrenador:");
        for (int i =0; i<entrenadores.size();i++){
            System.out.println((i+1)+ ". " + entrenadores.get(i).getNombre());
        }
        int seleccion=sc.nextInt();
        Entrenador entrenador= entrenadores.get(seleccion-1);
        gestionarEntrenador(entrenador);
    }
    
    private void gestionarEntrenador (Entrenador entrenador){
        int opcion;
        do{
            System.out.println("Entrenador: "+entrenador.getNombre());
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Encontar Pokémon");
            System.out.println("4. Volver a gestionar Entrenadores");
            System.out.print("Elige una opción: ");
            opcion=sc.nextInt();
            
            switch(opcion){
                case 1:
                    equipoPokemon(entrenador);
                    break;
                case 2:
                    agregarPokemon(entrenador);
                    break;
                case 3:
                    entrenarPokemon(entrenador);
                    break;
                case 4:
                    System.out.println("Volver a Gestionar Entrenadores...");
                    break;
                default:
                    System.out.println("Opción no valida");
            }
        }while (opcion!=4);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void menuPokemones(){
    
        int opcion;
        do{
            System.out.println("Gestionar Pokémones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion=sc.nextInt();
            
            switch (opcion){
                case 1:
                    listaPokemones();
                    break;
                case 2:
                    registrarPokemon();
                    break;
                case 3:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion !=3);
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private void menuBatalla(){
    
        int opcion;
        do{
            System.out.println("Iniciar Batalla");
            System.out.println("1. Elegir entrenador 1");
            System.out.println("2. Elegir entrenador 2");
            System.out.println("3. Seleccionar Pokémon de entrenador 1");
            System.out.println("4. Seleccionar Pokémon de entrenador 2");
            System.out.println("5. Comenzar batalla");
            System.out.println("6. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion=sc.nextInt();
            
            switch (opcion){
                case 1:
                    entrenador1=elegirEntrenador();
                    break;
                case 2:
                    entrenador2=elegirEntrenador();
                    break;
                case 3:
                    if(entrenador1 != null){
                        pokemon1=seleccionarPokemon(entrenador1);
                    }else{
                        System.out.println("Debe elegir al entrenador 1");
                    }
                    break;
                case 4:
                    if(entrenador2 != null){
                        pokemon2=seleccionarPokemon(entrenador2);
                    }else{
                        System.out.println("Debe elegir al entrenador 2");
                    }
                    break;
                case 5:
                    if (pokemon1 != null && pokemon2!=null){
                        batalla.iniciarBatalla(pokemon1, pokemon2);
                    }else{
                        System.out.println("Debes seleccionar ambos Pokémones antes de iniciar la batalla");
                    }
                    break; 
                case 6:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        }while (opcion !=6);
    }
    
    public Entrenador elegirEntrenador(){
        if (entrenadores.isEmpty()){
            System.out.println("No hay entrenadores registrados.");
            return null;
        }
        System.out.println("Selecciona un entrenador:");
        for (int i =0; i<entrenadores.size();i++){
            System.out.println((i+1)+ ". " + entrenadores.get(i).getNombre());
        }
        int seleccion=sc.nextInt();
        return entrenadores.get(seleccion-1);
    }
    
    public Pokemon seleccionarPokemon(Entrenador entrenador){
        if (entrenadores.getPokemones().isEmpty()){
            System.out.println("El entrenador no tiene Pokémones en su equipo.");
            return null;
        }
        System.out.println("Selecciona un Pokémon de "+entrenador.getNombre()+":");
        for (int i =0; i<entrenadores.getPokemones().size();i++){
            System.out.println((i+1)+ ". " + entrenadores.getPokemones().get(i).getNombre());
        }
        int seleccion=sc.nextInt();
        return entrenadores.getPokemones.get(seleccion-1);
    }
        
}//Cierre class
