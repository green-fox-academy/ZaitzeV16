package pokemon;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Pokemon> pokemonOfAsh = initializePokemons();

    // Every pokemon has a name and a type.
    // Certain types are effective against others, e.g. water is effective against fire.

    // Ash has a few pokemon.
    // A wild pokemon appeared!

    Pokemon wildPokemon = new Pokemon("Oddish", "leaf", "water");

    // Which pokemon should Ash use?
    Pokemon toUse = pickProperPokemon(pokemonOfAsh, wildPokemon);

    System.out.print("I choose you, " + toUse.name);
  }

  private static Pokemon pickProperPokemon(List<Pokemon> pokemonOfAsh, Pokemon wildPokemon) {
    Pokemon result = null;

    for (Pokemon currPok : pokemonOfAsh) {
      boolean effAttack = wildPokemon.type.equals(currPok.effectiveAgainst);
      boolean effDef = !wildPokemon.effectiveAgainst.equals(currPok.type);

      if (effAttack) {
        if (effDef) {
          return currPok;
        } else if (result == null) {
          result = currPok;
        }
      }
    }
    return result;
  }

  private static List<Pokemon> initializePokemons() {
    List<Pokemon> pokemon = new ArrayList<>();

    pokemon.add(new Pokemon("Balbasaur", "leaf", "water"));
    pokemon.add(new Pokemon("Pikachu", "electric", "water"));
    pokemon.add(new Pokemon("Charizard", "fire", "leaf"));
    pokemon.add(new Pokemon("Balbasaur", "water", "fire"));
    pokemon.add(new Pokemon("Kingler", "water", "fire"));

    return pokemon;
  }
}
