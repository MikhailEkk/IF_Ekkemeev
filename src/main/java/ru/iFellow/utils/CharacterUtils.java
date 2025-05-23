package ru.iFellow.utils;

import java.util.List;
import ru.iFellow.dto.RickAndMorty.Character;

public class CharacterUtils {

    private CharacterUtils() {

    }

    public static int findLastEpisode(Character character) {
        List<String> episodes = character.getEpisode();
        if (episodes == null || episodes.isEmpty()) {
            return -1;
        }

        int maxNumber = extractNumber(episodes.get(0));
        for (String episode : episodes) {
            int currentNumber = extractNumber(episode);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
        }
        return maxNumber;
    }

    public static int extractNumber(String episodeUrl) {
        try {
            String[] parts = episodeUrl.split("/");
            String lastPart = parts[parts.length - 1];
            return Integer.parseInt(lastPart);
        } catch (Exception e) {
            return -1;
        }
    }
}
