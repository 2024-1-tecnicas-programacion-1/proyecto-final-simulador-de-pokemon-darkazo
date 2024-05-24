package simulador;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int opcion;
        
        do{
        
            System.out.println("***Simulador de Batallas Pokemon***");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokemones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");

            opcion = sc.nextInt();
            
            switch (opcion){
                case 1: 
                    gestionarEntrenadores();
                    break;
                    
                case 2:
                    gestionarPokemones();
                    break;
                    
                case 3:
                    iniciarBatalla();
                    break;
                    
                case 4:
                    System.out.println("Saliendo del simulador...");
                    break;
                    
                default:
                    System.out.println("Opcion invalida");
                    break;
            }
        
        }while (opcion!=4);
        
 
    }//Cierre main
}//Cierre class
