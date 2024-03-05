package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemonBulbizarre;
    private Pokemon pokemonAquali;


    @Before
    public void setUp() throws PokedexException {
        pokedex = new Pokedex();

        pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        pokedex.addPokemon(pokemonBulbizarre);
        pokedex.addPokemon(pokemonAquali);
    }



    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        assertEquals(0, pokedex.addPokemon(pokemonBulbizarre));
        assertEquals(133, pokedex.addPokemon(pokemonAquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokemonBulbizarre, pokedex.getPokemon(0));
        assertEquals(pokemonAquali, pokedex.getPokemon(133));
    }

    @Test
    public void testGetPokemons() {
        assertEquals(Arrays.asList(pokemonBulbizarre, pokemonAquali), pokedex.getPokemons());
    }

}
