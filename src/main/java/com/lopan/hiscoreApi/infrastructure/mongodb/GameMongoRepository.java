package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.UUID;

@Component
@Primary
public class GameMongoRepository implements GameRepository {

    private final GameSpringMongoRepository springRepository;

    @Autowired
    public GameMongoRepository(GameSpringMongoRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Game saveGame(Game game) {
        return springRepository.save(game);
    }

    @Override
    public Game updateGame(Game game) {
        return null;
    }

    @Override
    public List<Game> listGames() {
        return springRepository.findAll();
    }

    @Override
    public List<Game> findGamesByName(String name) {
        return springRepository.findByNameLikeIgnoreCase(name);
    }

    @Override
    public Game findGameById(UUID id) {
        return springRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Game not found with this ID... =("));
    }
}
