package com.lopan.hiscoreApi.domain.game;

import java.util.List;
import java.util.UUID;

public interface GameRepository {

    public Game saveGame(Game game);
    public Game updateGame(Game game);
    public List<Game> listGames();
    public List<Game> findGamesByName(String name);
    public Game findGameById(UUID id);

}
