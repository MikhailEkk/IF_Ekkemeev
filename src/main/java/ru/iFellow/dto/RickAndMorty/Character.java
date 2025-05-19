package ru.iFellow.dto.RickAndMorty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class Character {
    private int id;
    private String name;
    private String status;
    private String species;
    private String type;
    private String gender;
    private Origin origin;
    private Location location;
    private String image;
    private ArrayList<String> episode;
    private String url;
    private Date created;

    public static int findLastEpisode(Character character) {

        List<String> episodes = character.getEpisode();
        int maxNumber = extractNumber(episodes.get(0));

        for (String episode : episodes) {
            int currentNumber = extractNumber(episode);
            if (currentNumber > maxNumber) {
                maxNumber = currentNumber;
            }
        }
        return maxNumber;
    }

    //метод для извлечения номера эпизода из URL
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
