package ru.iFellow.dto.RickAndMorty;

import lombok.Data;

@Data
public class Info {
    private int count;
    private int pages;
    private String next;
    private String prev;
}
