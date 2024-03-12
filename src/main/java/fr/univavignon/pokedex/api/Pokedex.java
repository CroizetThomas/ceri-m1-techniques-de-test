package fr.univavignon.pokedex.api;

import java.util.*;

/** Classe représentant un Pokedex. */
public class Pokedex implements IPokedex {

    // Liste des pokemons dans le Pokedex
    private List<Pokemon> pokemons;

    /**
     * Constructeur par défaut de la classe Pokedex.
     */
    public Pokedex() {
        pokemons = new ArrayList<>();
    }

    @Override
    public int size() {
        return pokemons.size();
    }

    @Override
    public int addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
        return pokemon.getIndex();
    }

    @Override
    public Pokemon getPokemon(int id) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == id) {
                return pokemon;
            }
        }
        return null;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sortedPokemons = new ArrayList<>(pokemons);
        Collections.sort(sortedPokemons, order);
        return Collections.unmodifiableList(sortedPokemons);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = getPokemonMetadata(index);
        if (pokemonMetadata == null) {
            throw new PokedexException("Invalid index");
        }
        pokemons.add(new Pokemon(index, pokemonMetadata.getName(), pokemonMetadata.getAttack(),
                pokemonMetadata.getDefense(), pokemonMetadata.getStamina(), cp, hp, dust, candy, 5));
        return pokemons.get(pokemons.size() - 1);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        for (Pokemon pokemon : pokemons) {
            if (pokemon.getIndex() == index) {
                return new PokemonMetadata(index, pokemon.getName(), pokemon.getAttack(),
                        pokemon.getDefense(), pokemon.getStamina());
            }
        }
        return null;
    }
}
