package Advanced.DefiningClassesEx.PokémonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Trainer {
    private String name;
    private int badgeNumber;
    private List<Pokemon> pokemonList;

    public Trainer(String name, Pokemon pokemon) {
        this.name = name;
        this.badgeNumber = 0;
        this.pokemonList = new ArrayList<>();
        this.pokemonList.add(pokemon);
    }

    public String getName() {
        return name;
    }

    public List<Pokemon> getPokemonList() {
        return pokemonList;
    }

    public int getBadgeNumber() {
        return badgeNumber;
    }

    public void receiveBadge() {
        badgeNumber++;
    }

    public void isAttacked() {
        pokemonList.forEach(Pokemon::loseHealth);
        pokemonList = pokemonList.stream().filter(pokemon -> pokemon.getHealth() >= 1).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", name, badgeNumber, pokemonList.size());
    }
}
