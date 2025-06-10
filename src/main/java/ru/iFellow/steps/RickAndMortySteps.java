package ru.iFellow.steps;

import io.cucumber.java.ru.Дано;
import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import io.qameta.allure.Epic;
import ru.iFellow.api.RickAndMortyAPI.CharacterAPI;
import ru.iFellow.api.RickAndMortyAPI.EpisodeAPI;
import ru.iFellow.dto.RickAndMorty.ResponseGetCharacters;
import ru.iFellow.dto.RickAndMorty.Character;
import ru.iFellow.dto.RickAndMorty.Episode;
import org.junit.jupiter.api.Assertions;

import java.util.List;

import static ru.iFellow.utils.CharacterUtils.extractNumber;
import static ru.iFellow.utils.CharacterUtils.findLastEpisode;

@Epic("Rick and Morty")
public class RickAndMortySteps {

    private static final CharacterAPI characterApi = new CharacterAPI();
    private static final EpisodeAPI episodeApi = new EpisodeAPI();

    private List<Character> listCharacters;
    private int maxEpisodeNumber = 1;
    private Episode episode;
    private List<String> listCharactersString;
    private String lastCharacter = "";
    int characterId;
    private String foundCharacterSpecies = "";
    private String foundLocationName = "";
    private String speciesMorty;
    private String locationMorty;

    @Дано("Получили список персонажей с именем {string}")
    public void getListCharactersByName(String name) {
        listCharacters = characterApi.getByParam("name", name)
                .extract()
                .body()
                .as(ResponseGetCharacters.class)
                .getResults();
    }

    @Когда("Определили последний эпизод появления персонажа")
    public void findLastEpisodeFroEachCharacter() {
        for (Character obj : listCharacters) {
            int currentEpisodeNumber = findLastEpisode(obj);
            if (maxEpisodeNumber < currentEpisodeNumber){
                maxEpisodeNumber = currentEpisodeNumber;
            }
        }
    }

    @Тогда("Номер последнего эпизода должен быть {int}")
    public void verifyMaxEpisode(int expectedEpisode) {
        Assertions.assertEquals(expectedEpisode, maxEpisodeNumber);
    }

    @Когда("Получили эпизод по id = {int}")
    public void getEpisodeById(int id) {
        episode = episodeApi.getById(maxEpisodeNumber)
                .extract()
                .body()
                .as(Episode.class);
    }

    @Когда("Получили список персонажей эпизода")
    public void getCharactersInEpisode() {
        listCharactersString = episode.getCharacters();
    }

    @Тогда("Url последнего персонажа в эпизоде должен быть {string}")
    public void checkUrlCharacter(String urlLastCharacterExpected) {
        lastCharacter = listCharactersString.get(listCharacters.size() - 1);
        Assertions.assertEquals(urlLastCharacterExpected, lastCharacter);
    }

    @Когда("Получили персонажа по id")
    public Character getCharacterById() {
        return characterApi.getById(characterId)
                .extract()
                .body()
                .as(Character.class);
    }

    @Когда("Извлекли id последнего персонажа из url")
    public void extractCharacterIdFromUrl() {
        characterId = extractNumber(lastCharacter);
    }

    @Когда("Получили расу и местонахождение персонажа")
    public void getSpecies() {
        Character character = getCharacterById();
        foundCharacterSpecies = character.getSpecies();
        foundLocationName = character.getLocation().getName();
    }

    @Тогда("Раса должна быть {string}")
    public void checkSpecies(String expectedSpecies) {
        Assertions.assertEquals(expectedSpecies, foundCharacterSpecies);
    }

    @Тогда("Название местонахождения должна быть {string}")
    public void checkLocationName(String expectedLocationName) {
        Assertions.assertEquals(expectedLocationName, foundLocationName);
    }

    @Когда("Получили расу и местонахождение {int} персонажа в списке")
    public void getSpeciesAndLocationNameByNumber(int number) {
        Character characterMorty = listCharacters.get(number);
        speciesMorty = characterMorty.getSpecies();
        locationMorty = characterMorty.getLocation().getName();
    }

    @Тогда("Название местонахождения должна быть такое же как у Морти")
    public void checkLocationNameWithLocationNameMorty() {
        Assertions.assertNotEquals(locationMorty, foundLocationName);
    }

    @Тогда("Раса должна быть такая же как у Морти")
    public void checkSpeciesWithSpeciesMorty() {
        Assertions.assertEquals(speciesMorty, foundCharacterSpecies);
    }
}
