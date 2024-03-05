package fr.univavignon.pokedex.api;

import java.util.*;

public class Pokedex implements IPokedex{

    List<Pokemon> pokemons;

    Pokedex(){
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
        for(int i = 0; i<pokemons.size(); i++){
            if (pokemons.get(i).getIndex() == id)
                return pokemons.get(i);
        }
        return null;
    }

    @Override
    public List<Pokemon> getPokemons() {
        return pokemons;
    }

    @Override
    public List<Pokemon> getPokemons(Comparator<Pokemon> order) {
        List<Pokemon> sort = new ArrayList<>(pokemons);
        Collections.sort(sort, order);

        return Collections.unmodifiableList(sort);
    }

    @Override
    public Pokemon createPokemon(int index, int cp, int hp, int dust, int candy) throws PokedexException {
        PokemonMetadata pokemonMetadata = getPokemonMetadata(index);
        if(pokemonMetadata == null)
            throw new PokedexException("Invalid index");
        return new Pokemon(index,pokemonMetadata.getName(),pokemonMetadata.getAttack(),pokemonMetadata.getDefense(),pokemonMetadata.getStamina(),cp,hp,dust,candy,5);
    }

    @Override
    public PokemonMetadata getPokemonMetadata(int index) throws PokedexException {
        Pokemon pokemon = getPokemon(index);

        PokemonMetadata metadata = new PokemonMetadata(pokemon.getIndex(), pokemon.getName(), pokemon.getAttack(), pokemon.getDefense(), pokemon.getStamina());

        return metadata;
    }
}
