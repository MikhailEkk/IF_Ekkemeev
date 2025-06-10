package ru.iFellow.api.RickAndMortyAPI;

import io.qameta.allure.Step;

public class EpisodeAPI extends BaseRickAndMortyAPI {
    private static final String EPISODE_END_POINT = props.getString("episode.endpoint");

    @Override
    @Step("Получить endpoint эпизодов")
    protected String getEndpoint() {
        return EPISODE_END_POINT;
    }
}
