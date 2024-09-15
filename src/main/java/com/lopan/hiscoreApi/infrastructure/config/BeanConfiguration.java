package com.lopan.hiscoreApi.infrastructure.config;

import com.lopan.hiscoreApi.domain.game.DomainGameService;
import com.lopan.hiscoreApi.domain.game.GameService;
import com.lopan.hiscoreApi.domain.score.DomainScoreService;
import com.lopan.hiscoreApi.domain.score.ScoreService;
import com.lopan.hiscoreApi.infrastructure.mongodb.GameMongoRepository;
import com.lopan.hiscoreApi.infrastructure.mongodb.ScoreMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    GameService gameService(GameMongoRepository gameRepository) {
        return new DomainGameService(gameRepository);
    }

    @Bean
    ScoreService scoreService(ScoreMongoRepository scoreRepository, GameService gameService) {
        return new DomainScoreService(scoreRepository, gameService);
    }
}
