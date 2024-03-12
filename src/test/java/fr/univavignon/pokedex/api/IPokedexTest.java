package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class IPokedexTest {

    private IPokedex pokedex;
    private Pokemon pokemonBulbizarre;
    private Pokemon pokemonAquali;


    @Before
    public void setUp() throws PokedexException {
        pokedex = new Pokedex();

        pokemonBulbizarre = new Pokemon(1, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
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
        assertEquals(1, pokedex.addPokemon(pokemonBulbizarre));
        assertEquals(133, pokedex.addPokemon(pokemonAquali));
    }

    @Test
    public void testGetPokemon() throws PokedexException {
        assertEquals(pokemonBulbizarre, pokedex.getPokemon(1));
        assertEquals(pokemonAquali, pokedex.getPokemon(133));
    }

    @Test
    public void testGetPokemons() {
        assertEquals(Arrays.asList(pokemonBulbizarre, pokemonAquali), pokedex.getPokemons());
    }

    @Test
    public void testGetPokemonsWithOrder() {
        Comparator<Pokemon> nameComparator = Comparator.comparing(Pokemon::getName);

        List<Pokemon> sortedPokemons = pokedex.getPokemons(nameComparator);

        assertThrows(UnsupportedOperationException.class, () -> sortedPokemons.add(pokemonBulbizarre));

        List<Pokemon> expectedSort = Arrays.asList(pokemonAquali, pokemonBulbizarre);
        assertEquals(expectedSort, sortedPokemons);
    }

    @Test
    public void testCreatePokemon() throws PokedexException {
        Pokemon createdPokemon = pokedex.createPokemon(1, 100, 100, 100, 100);

        Assert.assertEquals(1, createdPokemon.getIndex());
        Assert.assertEquals(100, createdPokemon.getCp());
        Assert.assertEquals(100, createdPokemon.getHp());
        Assert.assertEquals(100, createdPokemon.getDust());
        Assert.assertEquals(100, createdPokemon.getCandy());
    }
    @Test
    public void testGetPokemonMetadata() throws PokedexException {
        PokemonMetadata pokemonMetadata = pokedex.getPokemonMetadata(1);

        Assert.assertEquals(1, pokemonMetadata.getIndex());
        Assert.assertEquals("Bulbizarre", pokemonMetadata.getName());
        Assert.assertEquals(126, pokemonMetadata.getAttack());
        Assert.assertEquals(126, pokemonMetadata.getDefense());
        Assert.assertEquals(90, pokemonMetadata.getStamina());
    }
}
