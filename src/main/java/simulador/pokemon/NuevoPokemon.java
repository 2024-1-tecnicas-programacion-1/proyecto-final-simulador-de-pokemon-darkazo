
package simulador.pokemon;

import java.util.List;

public class NuevoPokemon extends Pokemon {
    public NuevoPokemon(String nombre, int salud, int puntosDeAtaque, List<String> tipo, Estado estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }

    @Override
    public void atacar(Combatiente oponente) {
        System.out.println(this.getNombre() + " ataca contra " + oponente.getNombre());
        double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), oponente.getTipo());
        int daño = (int) (this.getPuntosDeAtaque() * multiplicador);
        oponente.recibirDaño(daño);
        System.out.println(oponente.getNombre() + " recibe " + daño + " puntos de daño.");
    }

    @Override
    public void recibirDaño(int daño) {
        int nuevaSalud = this.getSalud() - daño;
        this.setSalud(nuevaSalud);
        System.out.println(this.getNombre() + " recibe " + daño + " puntos de daño. Salud restante: " + nuevaSalud);
        if (nuevaSalud <= 0) {
            System.out.println(this.getNombre() + " ha sido debilitado.");
        }
    }
}


