package ru.iFellow.api.RickAndMortyAPI;

public class EpisodeAPI extends BaseRickAndMortyAPI {
    private static final String EPISODE_END_POINT = props.getString("episode.endpoint");

    @Override
    protected String getEndpoint() {
        return EPISODE_END_POINT;
    }
}
