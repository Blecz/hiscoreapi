package com.lopan.hiscoreApi.domain.game;

import java.util.List;

public class DomainGameService implements GameService {

    private final GameRepository repository;

    public DomainGameService(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Game> findGames(String name) {
        if (name != null)
            return repository.findGamesByName(name);

        return repository.listGames();
    }

    @Override
    public Game createGame(Game game) {
        return repository.saveGame(game);
    }

    @Override
    public Game updateGame(Game game) {
        Game current = repository.findGameById(game.getId());
        return repository.updateGame(game.updateGame(game));
    }

}
