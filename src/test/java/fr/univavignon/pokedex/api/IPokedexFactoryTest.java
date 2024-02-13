package fr.univavignon.pokedex.api;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class IPokedexFactoryTest {

    private IPokemonMetadataProvider metadataProviderMock;
    private IPokemonFactory pokemonFactoryMock;

    @Before
    public void setUp() {
        metadataProviderMock = mock(IPokemonMetadataProvider.class);
        pokemonFactoryMock = mock(IPokemonFactory.class);
    }

    @Test
    public void testCreatePokedex() {
        IPokedex pokedexMock = mock(IPokedex.class);
        IPokedexFactory pokedexFactory = (metadataProvider, pokemonFactory) -> pokedexMock;
        IPokedex pokedex = pokedexFactory.createPokedex(metadataProviderMock, pokemonFactoryMock);

        assertEquals(pokedexMock, pokedex);
    }
}
