
package simulador.pokemon;


public class Rhyhorn extends Pokemon{
    
    public Rhyhorn() {
        super("Rhyhorn", 80, 85, TipoPokemon.TIERRA.ROCA, Estado.Normal);
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
