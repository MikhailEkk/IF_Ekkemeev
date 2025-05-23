package ru.iFellow.dto.RickAndMorty;

import lombok.Data;

import java.util.ArrayList;
import java.util.Date;

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
}
