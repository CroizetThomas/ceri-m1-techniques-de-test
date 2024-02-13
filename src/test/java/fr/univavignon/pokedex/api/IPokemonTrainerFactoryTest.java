package fr.univavignon.pokedex.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;

public class IPokemonTrainerFactoryTest {

    private PokemonTrainer trainer;
    private IPokedex pokedexMock;

    @Before
    public void setUp() {
        pokedexMock = mock(IPokedex.class);
        trainer = new PokemonTrainer("Ash", Team.VALOR, pokedexMock);
    }

    @Test
    public void testGetName() {
        assertEquals("Ash", trainer.getName());
    }

    @Test
    public void testGetTeam() {
        assertEquals(Team.VALOR, trainer.getTeam());
    }

    @Test
    public void testGetPokedex() {
        assertEquals(pokedexMock, trainer.getPokedex());
    }

}
