package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class IPokemonFactoryTest {

    private Pokemon pokemon;

    @Before
    public void setUp() {
        PokemonMetadata metadata = new PokemonMetadata(1, "Bulbasaur", 49, 49, 45);
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

    @Test
    public void testMetadata() {
        assertEquals(1, pokemon.getIndex());
        assertEquals("Bulbasaur", pokemon.getName());
        assertEquals(49, pokemon.getAttack());
        assertEquals(49, pokemon.getDefense());
        assertEquals(45, pokemon.getStamina());
    }

}

