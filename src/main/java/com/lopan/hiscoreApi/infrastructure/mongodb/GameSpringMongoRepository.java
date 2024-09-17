package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.game.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@Repository
public interface GameSpringMongoRepository extends MongoRepository<Game, UUID> {

    public List<Game> findByNameLikeIgnoreCase(String name);

}
