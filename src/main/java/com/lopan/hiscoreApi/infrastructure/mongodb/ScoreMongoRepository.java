package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.score.Score;
import com.lopan.hiscoreApi.domain.score.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

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
    public List<Score> saveScores(List<Score> scores) {
        return springRepository.saveAll(scores);
    }

    @Override
    public List<Score> listScore(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField) {
        return null;
    }
}
