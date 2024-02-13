package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private Pokemon pokemon;
    private IPokemonMetadataProvider iPokemonMetadataProvider;

    @Before
    public void setUp() throws PokedexException {
        iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);
        when(iPokemonMetadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Bulbasaur", 49, 49, 45));
        pokemon = new Pokemon(1, "Bulbasaur", 49, 49, 45, 10, 20, 100, 5, 90.5);
    }

    @Test
    public void testCP() {
        assertEquals(10, pokemon.getCp());
    }

    @Test
    public void testHP() {
        assertEquals(20, pokemon.getHp());
    }

    @Test
    public void testDust() {
        assertEquals(100, pokemon.getDust());
    }

    @Test
    public void testCandy() {
        assertEquals(5, pokemon.getCandy());
    }

    @Test
    public void testIV() {
        assertEquals(90.5, pokemon.getIv(), 0.01);
    }
}

