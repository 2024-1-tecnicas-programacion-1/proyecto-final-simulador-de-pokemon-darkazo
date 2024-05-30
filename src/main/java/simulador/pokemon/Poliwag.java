
package simulador.pokemon;

import java.util.Arrays;

public class Poliwag extends Pokemon {
    
    public Poliwag (){
        super("Poliwag", 40, 50,Arrays.asList("AGUA"), Estado.NORMAL);
    }
    
    @Override
    public void atacar(Combatiente oponente) {
        System.out.println(this.getNombre() + " ataca contra " + oponente.getNombre());
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println(oponente.getNombre() + " recibe " + daño + " puntos de daño.");
    }//Cierre atacar

    @Override
    public void recibirDaño(int daño) {
        
        int nuevaSalud = this.getSalud() - daño;
      
        this.setSalud(nuevaSalud);
        
        
        System.out.println(this.getNombre() + " recibe " + daño + " puntos de daño. Salud restante: " + nuevaSalud);
        
        
        if (nuevaSalud <= 0) {
            System.out.println(this.getNombre() + " ha sido debilitado.");
        }
    }
    
}//Cierre class
