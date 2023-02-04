package Advanced.DefiningClassesEx.PokémonTrainer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Trainer> trainerList = new ArrayList<>();

        String command = scanner.nextLine();
        while (!command.equals("Tournament")) {
            String[] tokens = command.split("\\s+");

            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);

            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);

            if (trainerList.stream().noneMatch(t -> t.getName().equals(trainerName))) {
                trainerList.add(new Trainer(trainerName, pokemon));
            } else {
                trainerList.stream().filter(t -> t.getName().equals(trainerName)).findFirst().get().getPokemonList().add(pokemon);
            }

            command = scanner.nextLine();
        }

        command = scanner.nextLine();
        while (!command.equals("End")) {
            String element = command;

            trainerList.forEach(trainer -> {
                        boolean pokemonWithElementExist = trainer.getPokemonList().stream().anyMatch(pokemon -> pokemon.getElement().equals(element));
                        if (pokemonWithElementExist) {
                            trainer.receiveBadge();
                        } else {
                            trainer.isAttacked();
                        }
                    });

            command = scanner.nextLine();
        }

        trainerList.stream()
                .sorted((t1, t2) -> Integer.compare(t2.getBadgeNumber(), t1.getBadgeNumber()))
                .forEach(System.out::println);
    }
}
