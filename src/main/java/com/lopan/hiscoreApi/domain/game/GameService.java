package com.lopan.hiscoreApi.domain.game;

import java.util.List;
import java.util.UUID;

public interface GameService {

    public List<Game> findGames(String name);
    public Game createGame(Game game);
    public Game updateGame(Game game);
    public Game getGame(UUID id);

}
