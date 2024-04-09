package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class RocketPokemonFactoryTest {

    private IPokemonFactory factory;

    @Before
    public void setUp() {
        factory = new RocketPokemonFactory();
    }

    @Test
    public void testCreatePokemonWithValidIndex() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(1, 100, 100, 100, 10);

        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(100, pokemon.getCp());
        assertEquals(100, pokemon.getHp());
        // Add more assertions as needed
    }

    @Test
    public void testCreatePokemonWithInvalidIndex() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(-1, 200, 200, 200, 20);

        assertEquals(0, pokemon.getIndex()); // Since index is invalid, it should default to 0
        assertEquals("MISSINGNO", pokemon.getName());
        assertEquals(1000, pokemon.getCp()); // Default values for invalid index
        assertEquals(1000, pokemon.getHp());
        // Add more assertions as needed
    }

    @Test
    public void testCreatePokemonWithRandomStats() throws PokedexException {
        Pokemon pokemon = factory.createPokemon(1, 200, 200, 200, 20);

        // Assert that attack, defense, and stamina are generated randomly
        // For simplicity, you may need to adjust these assertions based on your actual implementation
        assertEquals(100, pokemon.getAttack());
        assertEquals(100, pokemon.getDefense());
        assertEquals(100, pokemon.getStamina());
        assertEquals(1.0, pokemon.getIv(), 0.01); // IV should be set to 1.0 for valid index
    }

    // Add more test methods as needed
}
