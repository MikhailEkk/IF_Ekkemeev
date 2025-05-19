package ru.iFellow.dto.RickAndMorty;

import lombok.Data;

import java.util.List;

@Data
public class ResponseGetCharacters {
    private Info info;
    private List<Character> results;
}
