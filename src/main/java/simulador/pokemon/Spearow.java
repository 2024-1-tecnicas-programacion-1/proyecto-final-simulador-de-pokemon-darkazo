
package simulador.pokemon;

public class Spearow extends Pokemon{
    
    public Spearow(){
        super("Spearow", 40, 60, TipoPokemon.NORMAL.VOLADOR, Estado.Normal);
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
