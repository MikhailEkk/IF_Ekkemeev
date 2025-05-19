package ru.iFellow.dto.RickAndMorty;

import lombok.Data;

import java.util.List;
import java.util.Date;

@Data
public class Episode {
    private int id;
    private String name;
    private String air_date;
    private String episode;
    private List<String> characters;
    private String url;
    private Date created;

}
