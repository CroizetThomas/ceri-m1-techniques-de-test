package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() {
        pokemonMetadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);
    }

    @Test
    public void testIndex() {
        assertEquals(1, pokemonMetadata.getIndex());
    }

    @Test
    public void testName() {
        assertEquals("Bulbasaur", pokemonMetadata.getName());
    }

    @Test
    public void testAttack() {
        assertEquals(49, pokemonMetadata.getAttack());
    }

    @Test
    public void testDefense() {
        assertEquals(49, pokemonMetadata.getDefense());
    }

    @Test
    public void testStamina() {
        assertEquals(45, pokemonMetadata.getStamina());
    }
}
