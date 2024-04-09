package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonFactoryTest {

    private Pokemon pokemonBulbizarre;
    private Pokemon pokemonAquali;

    @Before
    public void setUp() throws PokedexException {


        IPokemonMetadataProvider iPokemonMetadataProvider = mock(IPokemonMetadataProvider.class);

        when(iPokemonMetadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(iPokemonMetadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

        pokemonBulbizarre = new Pokemon(0, "Bulbizarre", 126, 126, 90, 613, 64, 4000, 4, 56);
        pokemonAquali = new Pokemon(133, "Aquali", 186, 168, 260, 2729, 202, 5000, 4, 100);
    }

    @Test
    public void testCP() {
        assertEquals(613, pokemonBulbizarre.getCp());
        assertEquals(2729, pokemonAquali.getCp());
    }

    @Test
    public void testHP() {
        assertEquals(64, pokemonBulbizarre.getHp());
        assertEquals(202, pokemonAquali.getHp());
    }

    @Test
    public void testDust() {
        assertEquals(4000, pokemonBulbizarre.getDust());
        assertEquals(5000, pokemonAquali.getDust());
    }

    @Test
    public void testCandy() {
        assertEquals(4, pokemonBulbizarre.getCandy());
        assertEquals(4, pokemonAquali.getCandy());
    }

    @Test
    public void testIV() {
        assertEquals(56, pokemonBulbizarre.getIv(), 0.01);
        assertEquals(100, pokemonAquali.getIv(), 0.01);
    }
}
