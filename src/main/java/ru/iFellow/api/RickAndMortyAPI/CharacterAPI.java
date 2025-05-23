package ru.iFellow.api.RickAndMortyAPI;

public class CharacterAPI extends BaseRickAndMortyAPI {

    private static final String CHARACTER_END_POINT = props.getString("character.endpoint");

    @Override
    protected String getEndpoint() {
        return CHARACTER_END_POINT;
    }
}
