package com.lopan.hiscoreApi.domain.game;

import java.util.List;

public interface GameService {

    public List<Game> searchGames(String name);
    public Game createGame(Game game);
    public Game updateGame(Game game);
    public void deleteGame(String gameId);

}
