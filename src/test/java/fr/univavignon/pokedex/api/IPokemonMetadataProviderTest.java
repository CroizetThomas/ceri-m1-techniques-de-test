package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private IPokemonMetadataProvider metadataProvider;
    private PokemonMetadata pokemonMetadata;

    @Before
    public void setUp() throws PokedexException {

        metadataProvider = mock(IPokemonMetadataProvider.class);
        when(metadataProvider.getPokemonMetadata(1)).thenReturn(new PokemonMetadata(1, "Bulbasaur", 49, 49, 45));
        pokemonMetadata = metadataProvider.getPokemonMetadata(1);
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
