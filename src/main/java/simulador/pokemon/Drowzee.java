
package simulador.pokemon;

public class Drowzee extends Pokemon{
    
    public Drowzee(){
        super("Drowzee", 60, 48, TipoPokemon.PSIQUICO, Estado.Normal);
    }
    
    @Override
    public void atacar (Combatiente oponente){
        if (oponente instanceof Pokemon){
            Pokemon pokemonOponente = (Pokemon) oponente;
            double multiplicador = TipoPokemon.obtenerMultiplicadorDeDaño(this.getTipo(), pokemonOponente.getTipo());
            int dañoBase= this.getPuntosDeAtaque();
            int dañoFinal= (int) (dañoBase * multiplicador);
            System.out.println(this.getNombre()+" ATACA!");
            pokemonOponente.recibirDaño(dañoFinal);
        }else {
            System.out.println("El oponente no es un Pokémon valido.");
        }
    }
}

