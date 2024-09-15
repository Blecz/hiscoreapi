package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.score.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface ScoreSpringMongoRepository extends MongoRepository<Score, UUID> {

    // TODO: Custom sorting
}
