package ru.iFellow.api.RickAndMortyAPI;

import io.qameta.allure.Step;

public class CharacterAPI extends BaseRickAndMortyAPI {

    private static final String CHARACTER_END_POINT = props.getString("character.endpoint");

    @Override
    @Step("Получить endpoint персонажей")
    protected String getEndpoint() {
        return CHARACTER_END_POINT;
    }
}
