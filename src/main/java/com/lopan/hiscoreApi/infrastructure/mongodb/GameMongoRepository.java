package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.game.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class GameMongoRepository implements GameRepository {

    private final GameSpringMongoRepository springRepository;

    @Autowired
    public GameMongoRepository(GameSpringMongoRepository springRepository) {
        this.springRepository = springRepository;
    }


}
