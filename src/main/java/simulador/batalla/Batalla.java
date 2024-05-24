package simulador.batalla;

import simulador.pokemon.Pokemon;
import simulador.pokemon.TipoPokemon;
import java.util.Scanner;

public class Batalla {
    
    private Entrenador entrenador1;
    private Entrenador entrenador2;
    private Scanner sc;
    
    public Batalla(){
        Scanner sc = new Scanner(System.in);    
    }
    
    public void iniciarBatalla(Entrenador entrenador1, Entrenador entrenador2){
    
            this.entrenador1 = entrenador1;
            this.entrenador2 = entrenador2;
            Pokemon pokemon1 = entrenador1.getPokemon();
            Pokemon pokemon2 = entrenador2.getPokemon();
            boolean batallaEnCurso=true;
            
            while (batallaEnCurso){
                System.out.println(pokemon1.getNombre()+" vs "+pokemon2.getNombre());

                System.out.println("1. "+pokemon1.getNombre()+" Atacar");
                System.out.println("2. "+pokemon2.getNombre()+" Atacar");
                System.out.println("3. Finalizar la batalla");
                System.out.print("Elige una opcion: ");
                int opcion = sc.nextInt();
                
                switch (opcion){
                    case 1:
                        atacar(pokemon1,pokemon2);
                        break;
                        
                    case 2:
                        atacar(pokemon2,pokemon1);
                        break;
                        
                    case 3:
                        batallaEnCurso=false;
                        break;
                        
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                
                if (!pokemon1.estaVivo() || !pokemon2.estaVivo()){
                    batallaEnCurso=false;
                    determinarGanador(pokemon1,pokemon2);  
                }
            }  
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
