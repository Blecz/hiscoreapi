package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.score.Score;
import com.lopan.hiscoreApi.domain.score.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
@Primary
public class ScoreMongoRepository implements ScoreRepository {

    private static ScoreSpringMongoRepository springRepository;

    @Autowired
    public ScoreMongoRepository(ScoreSpringMongoRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public Score saveScore(Score score) {
        return springRepository.save(score);
    }

    @Override
    public List<Score> listScore(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField) {
        return null;
    }
}
