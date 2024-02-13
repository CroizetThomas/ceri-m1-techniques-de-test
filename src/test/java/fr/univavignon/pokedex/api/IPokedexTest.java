package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;


public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemonBulbizarre;
    private Pokemon pokemonAquali;


    @Before
    public void setUp() throws PokedexException {
        pokedex = mock(IPokedex.class);

        pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);

        when(pokedex.size()).thenReturn(2);
        when(pokedex.addPokemon(any(Pokemon.class))).thenReturn(pokemonBulbizarre.getIndex(), pokemonAquali.getIndex());
        when(pokedex.getPokemon(0)).thenReturn(pokemonBulbizarre);
        when(pokedex.getPokemon(133)).thenReturn(pokemonAquali);
        when(pokedex.getPokemons()).thenReturn(Arrays.asList(pokemonBulbizarre, pokemonAquali));
        when(pokedex.getPokemons(null)).thenReturn(Arrays.asList(pokemonBulbizarre, pokemonAquali));
    }



    @Test
    public void testSize() {
        assertEquals(2, pokedex.size());
    }

    @Test
    public void testAddPokemon() {
        int indexBulbizarre = pokedex.addPokemon(pokemonBulbizarre);
        int indexAquali = pokedex.addPokemon(pokemonAquali);
        assertEquals(0, indexBulbizarre);
        assertEquals(133, indexAquali);
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
