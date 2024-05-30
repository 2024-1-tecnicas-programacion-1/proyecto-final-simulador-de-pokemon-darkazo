
package simulador.pokemon;

public class NuevoPokemon extends Pokemon {
    public NuevoPokemon(String nombre, int salud, int puntosDeAtaque, TipoPokemon tipo, Estado estado) {
        super(nombre, salud, puntosDeAtaque, tipo, estado);
    }

    @Override
    public void atacar(Combatiente oponente) {
      if (oponente instanceof Pokemon){
            Pokemon pokemonOponente = (Pokemon) oponente;
            double multiplicador = TipoPokemon.obtenerMultiplicadorDeDanio(this.getTipo(), pokemonOponente.getTipo());
            int danioBase= this.getPuntosDeAtaque();
            int danioFinal= (int) (danioBase * multiplicador);
            System.out.println(this.getNombre()+" ATACA!");
            pokemonOponente.recibirDanio(danioFinal);
        }else {
            System.out.println("El oponente no es un Pokémon valido.");
        }
    }
}


