
package simulador.pokemon;

import java.util.Arrays;

public class Meowth extends Pokemon{
    
    public Meowth (){
        super("Meowth", 40, 45,Arrays.asList("NORMAL"), Estado.NORMAL);
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