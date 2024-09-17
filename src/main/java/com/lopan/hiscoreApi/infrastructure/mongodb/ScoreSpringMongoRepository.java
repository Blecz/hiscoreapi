package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.score.Score;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.stream.Stream;

public interface ScoreSpringMongoRepository extends MongoRepository<Score, UUID> {

    public Stream<Score> findByGameIdAndTimestampBetween(UUID gameId, LocalDateTime startDate, LocalDateTime endDate);

}
