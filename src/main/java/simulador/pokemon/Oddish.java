
package simulador.pokemon;

public class Oddish extends Pokemon{
    
    public Oddish() {
        super("Oddish", 45, 50, TipoPokemon.PLANTA.VENENO, Estado.Normal);
    }

    @Override
    public void atacar (Combatiente oponente){
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
