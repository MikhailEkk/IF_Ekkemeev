package ru.iFellow.steps;

import ru.iFellow.api.RickAndMortyAPI.CharacterAPI;
import ru.iFellow.api.RickAndMortyAPI.EpisodeAPI;
import ru.iFellow.dto.RickAndMorty.ResponseGetCharacters;
import ru.iFellow.dto.RickAndMorty.Character;
import ru.iFellow.dto.RickAndMorty.Episode;

import java.util.List;

public class RickAndMortySteps {

    private static final CharacterAPI characterApi = new CharacterAPI();
    private static final EpisodeAPI episodeApi = new EpisodeAPI();

    public List<Character> getListCharactersByName(String name) {
        return characterApi.getByName(name)
                .extract()
                .body()
                .as(ResponseGetCharacters.class)
                .getResults();
    }

    public Episode getEpisodeById(int id) {
        return episodeApi.getById(id)
                .extract()
                .body()
                .as(Episode.class);
    }

    public Character getCharacterById(int id) {
        return characterApi.getById(id)
                .extract()
                .body()
                .as(Character.class);
    }
}
