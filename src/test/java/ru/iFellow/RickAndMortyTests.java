package ru.iFellow;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.iFellow.dto.RickAndMorty.Character;
import ru.iFellow.dto.RickAndMorty.Episode;
import ru.iFellow.steps.RickAndMortySteps;

import java.util.List;

import static ru.iFellow.utils.CharacterUtils.extractNumber;
import static ru.iFellow.utils.CharacterUtils.findLastEpisode;

public class RickAndMortyTests {

    private static final RickAndMortySteps rickAndMortySteps = new RickAndMortySteps();

    private int maxEpisodeNumber = 1;
    private String lastCharacter = "";
    private String foundCharacterSpecies = "";
    private String foundLocationName = "";

    @Test
    @DisplayName("Проверить последний эпизод появления персонажа")
    public void checkLastAppearanceEpisodeByName() {
        List<Character> listCharacters = rickAndMortySteps.getListCharactersByName("Morty Smith");
        for (Character obj : listCharacters) {
            int currentEpisodeNumber = findLastEpisode(obj);
            if (maxEpisodeNumber < currentEpisodeNumber){
                maxEpisodeNumber = currentEpisodeNumber;
            }
        }
        Assertions.assertEquals(51, maxEpisodeNumber);
    }

    @Test
    @DisplayName("Проверить последнего в списке персонажа в эпизоде")
    public void checkLastCharacterInEpisode() {
        checkLastAppearanceEpisodeByName();
        Episode episode = rickAndMortySteps.getEpisodeById(maxEpisodeNumber);
        List<String> listCharacters = episode.getCharacters();
        lastCharacter = listCharacters.get(listCharacters.size() - 1);
        Assertions.assertEquals("https://rickandmortyapi.com/api/character/825", lastCharacter);
    }

    @Test
    @DisplayName("Проверить местонахождение и расу персонажа найденного эпизода")
    public void checkLocationAndSpeciesCharacter() {
        checkLastCharacterInEpisode();
        int characterId = extractNumber(lastCharacter);
        Character character = rickAndMortySteps.getCharacterById(characterId);
        foundCharacterSpecies = character.getSpecies();
        foundLocationName = character.getLocation().getName();
        Assertions.assertEquals("Human", foundCharacterSpecies);
        Assertions.assertEquals("Earth (Unknown dimension)", foundLocationName);
    }

    @Test
    @DisplayName("Проверить, что раса совпадает, а местонахождение нет")
    public void checkLocationAndSpeciesWithMorty() {
        checkLocationAndSpeciesCharacter();
        List<Character> listCharacters = rickAndMortySteps.getListCharactersByName("Morty Smith");
        Character characterMorty = listCharacters.get(0);
        String speciesMorty = characterMorty.getSpecies();
        String locationMorty = characterMorty.getLocation().getName();
        Assertions.assertEquals(speciesMorty, foundCharacterSpecies);
        Assertions.assertNotEquals(locationMorty, foundLocationName);
    }
}
