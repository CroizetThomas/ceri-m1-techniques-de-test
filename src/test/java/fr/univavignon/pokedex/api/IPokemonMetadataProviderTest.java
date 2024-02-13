package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class IPokemonMetadataProviderTest {

    private PokemonMetadata pokemonMetadataBulbizarre;
    private PokemonMetadata pokemonMetadataAquali;

    @Before
    public void setUp() throws PokedexException {
        IPokemonMetadataProvider metadataProvider = mock(IPokemonMetadataProvider.class);

        when(metadataProvider.getPokemonMetadata(0)).thenReturn(new PokemonMetadata(0, "Bulbizarre", 126, 126, 90));
        when(metadataProvider.getPokemonMetadata(133)).thenReturn(new PokemonMetadata(133, "Aquali", 186, 168, 260));

        pokemonMetadataBulbizarre = metadataProvider.getPokemonMetadata(0);
        pokemonMetadataAquali = metadataProvider.getPokemonMetadata(133);
    }

    @Test
    public void testIndex() {
        assertEquals(0, pokemonMetadataBulbizarre.getIndex());
        assertEquals(133, pokemonMetadataAquali.getIndex());
    }

    @Test
    public void testName() {
        assertEquals("Bulbizarre", pokemonMetadataBulbizarre.getName());
        assertEquals("Aquali", pokemonMetadataAquali.getName());
    }

    @Test
    public void testAttack() {
        assertEquals(126, pokemonMetadataBulbizarre.getAttack());
        assertEquals(186, pokemonMetadataAquali.getAttack());
    }

    @Test
    public void testDefense() {
        assertEquals(126, pokemonMetadataBulbizarre.getDefense());
        assertEquals(168, pokemonMetadataAquali.getDefense());
    }

    @Test
    public void testStamina() {
        assertEquals(90, pokemonMetadataBulbizarre.getStamina());
        assertEquals(260, pokemonMetadataAquali.getStamina());
    }
}
