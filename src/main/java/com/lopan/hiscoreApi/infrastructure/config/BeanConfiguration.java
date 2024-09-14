package com.lopan.hiscoreApi.infrastructure.config;

import com.lopan.hiscoreApi.domain.game.DomainGameService;
import com.lopan.hiscoreApi.domain.game.GameService;
import com.lopan.hiscoreApi.infrastructure.mongodb.GameMongoRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    GameService gameService(GameMongoRepository gameRepository) {
        return new DomainGameService(gameRepository);
    }

}
