package simulador.pokemon;

public enum TipoPokemon {
    
    FUEGO,AGUA,PLANTA,VENENO,ELECTRICO,PSIQUICO,ROCA,TIERRA,NORMAL,VOLADOR,HADA,LUCHA,ACERO,BICHO,HIELO,FANTASMA,DRAGON;
    
    public static double obtenerMultiplicadorDeDanio(TipoPokemon atacante, TipoPokemon defensor){
        double[][] efectividad = {
         // FUEGO  AGUA  PLANTA VENENO ELECT PSIQ ROCA TIERR NORM VOLADOR HADA LUCHA ACERO BICHO HIELO FANTA DRAG
            { 1,    0.5,   2,    1,    1,    1,   0.5,   1,    1,    1,    1,    1,   0.5,   2,    2,    1,  0.5 }, // FUEGO
            { 2,     1,   0.5,   1,    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,    1,    1,   1 }, // AGUA
            { 0.5,   2,    1,   0.5,   1,    1,    2,    2,    1,    1,    1,    1,   0.5,  0.5,   1,    1,  0.5 }, // PLANTA
            { 1,     1,    2,    1,    1,    1,   0.5,   1,    1,    1,    2,    1,    1,    1,    1,   0.5,  1 }, // VENENO
            { 1,     2,   0.5,   1,    1,    1,    1,    0,    1,    2,    1,    1,    1,    1,    1,    1,   1 }, // ELECTRICO
            { 1,     1,    1,    2,    1,    1,    1,    1,    1,    1,    1,    2,    1,    1,    1,    1,   1 }, // PSIQUICO
            { 2,     1,    1,    1,    1,    1,    1,    1,    1,    2,    1,   0.5,   2,    2,    2,    1,   1 }, // ROCA
            { 2,     1,    1,    2,    0,    1,    2,    1,    1,   0.5,   1,    1,    2,    1,    1,    1,   1 }, // TIERRA
            { 1,     1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,    0,   1 }, // NORMAL
            { 1,     1,    2,    1,    2,    1,   0.5,   1,    1,    1,    1,    1,    1,    2,    1,    1,   1 }, // VOLADOR
            { 1,     1,    1,    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,    1,    1,    1,   1 }, // HADA
            { 1,     1,    1,    1,    1,   0.5,   2,    1,    2,    1,   0.5,   1,    1,    1,    2,   0.5,  1 }, // LUCHA
            { 2,     1,    1,    1,    1,   0.5,   2,    1,    1,    1,    2,    2,    1,    1,    1,    1,   1 }, // ACERO
            { 1,     1,    2,    1,    1,    1,    1,    1,    1,    2,    1,    1,   0.5,   1,    1,   0.5,  1 }, // BICHO
            { 1,     1,    2,    1,    1,    1,    1,    2,    1,    1,    1,    1,    1,    1,    1,    1,   2 }, // HIELO
            { 1,     1,    1,   0.5,   1,    1,    1,    1,    0,    1,    1,    1,    1,    1,    1,    2,   1 }, // FANTASMA
            { 1,     1,    1,    1,    1,    1,    1,    1,    1,    1,    0,    1,   0.5,   1,    1,    1,   2 }, // DRAGON
        };

        return efectividad[atacante.ordinal()][defensor.ordinal()];
    }
}//Cierre class
