package simulador.batalla;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;


public class Batalla {
    
//iniciarBatalla
// Complejidad temporal: O(n) Tiempo lineal.
    
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
        
        System.out.println("¡Comienza la batalla entre "+pokemon1.getNombre()+" y "+pokemon2.getNombre()+"!");
        
        while (pokemon1.estaVivo() && pokemon2.estaVivo()){
            pokemon1.atacar(pokemon2);
            if(!pokemon2.estaVivo()){
                System.out.println(pokemon2.getNombre()+" ha sido derrotado!");
                break;
            }
        
            pokemon2.atacar(pokemon1);
            if (!pokemon1.estaVivo()){
                System.out.println(pokemon1.getNombre()+" ha sido derrotado!");         
            }
        }
        System.out.println("La batalla ha terminado.");
        
        if (pokemon1.estaVivo() && !pokemon2.estaVivo()){
         System.out.println(pokemon1.getNombre()+ " ha ganado la batalla");
        }else if (!pokemon1.estaVivo() && pokemon2.estaVivo()){
            System.out.println(pokemon2.getNombre()+ " ha ganado la batalla");
        }else{
            System.out.println("La batalla ha terminado, EMPATE");
        }
    }


 
    
    
}//Cierre class
