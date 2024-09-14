package com.lopan.hiscoreApi.domain.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public class DomainGameService implements GameService {

    private final GameRepository repository;

    public DomainGameService(GameRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Game> searchGames(String name) {
        return null;
    }

    @Override
    public Game createGame(Game game) {
        return null;
    }

    @Override
    public Game updateGame(Game game) {
        return null;
    }

    @Override
    public void deleteGame(String gameId) {

    }
}
