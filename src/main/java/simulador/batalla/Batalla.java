package simulador.batalla;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;

public class Batalla {
    
    public void iniciarBatalla(Pokemon pokemon1, Pokemon pokemon2){
        while (pokemon1.estaVivo() && pokemon2.estaVivo()){
            mostrarEstado(pokemon1, pokemon2);
            turnoAtaque(pokemon1, pokemon2);
            
            if(!pokemon2.estaVivo()){
                System.out.println(pokemon2.getNombre()+" ha sido derrotado!");
                break;
            }
            
            mostrarEstado(pokemon1, pokemon2);
            turnoAtaque(pokemon1, pokemon2);
        
            if (!pokemon1.estaVivo()){
                System.out.println(pokemon1.getNombre()+" ha sido derrotado!");         
            }
        }
        
        System.out.println("La batalla ha terminado.");
    }
    
    private void atacar (Pokemon atacante, Pokemon defensor){
    
       defensor.recibirDaño(atacante.getPuntosDeAtaque());
       System.out.println(atacante.getNombre() + " atacó a " + defensor.getNombre() + " causando " + atacante.getPuntosDeAtaque() + " de daño.");
        System.out.println(defensor.getNombre() + " tiene ahora " + defensor.getSalud() + " puntos de vida.");
    }
    
    private void determinarGanador(){
        if (pokemon1.estaVivo() && !pokemon2.estaVivo()){
         System.out.println(pokemon1.getNombre()+ " ha ganado la batalla");
        }else if (!pokemon1.estaVivo() && pokemon2.get.estaVivo()){
            System.out.println(pokemon2.getNombre()+ " ha ganado la batalla");
        }else{
            System.out.println("La batalla ha terminado, EMPATE");
        }
    }
    
    
}//Cierre class
