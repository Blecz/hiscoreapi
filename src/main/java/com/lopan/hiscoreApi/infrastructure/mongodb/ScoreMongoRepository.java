package com.lopan.hiscoreApi.infrastructure.mongodb;

import com.lopan.hiscoreApi.domain.score.Score;
import com.lopan.hiscoreApi.domain.score.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Component
@Primary
public class ScoreMongoRepository implements ScoreRepository {

    private final ScoreSpringMongoRepository springRepository;

    @Autowired
    public ScoreMongoRepository(ScoreSpringMongoRepository springRepository) {
        this.springRepository = springRepository;
    }

    @Override
    public List<Score> saveScores(List<Score> scores) {
        return springRepository.saveAll(scores);
    }

    @Override
    public List<Score> listScore(UUID gameId, LocalDateTime startDate, LocalDateTime endDate, String sortingField, Boolean isAscending) {
        Comparator<Score> comparator;

        try {
            comparator = Comparator.comparingDouble(score -> Double.parseDouble(score.getScoreInfo().get(sortingField)));
        } catch (Exception e) {
            throw new RuntimeException("Sorting field is not a number, cannot be classified");
        }

        return
        isAscending ?
                springRepository.findByGameIdAndTimestampBetween(gameId, startDate, endDate).sorted(comparator).toList() :
                springRepository.findByGameIdAndTimestampBetween(gameId, startDate, endDate).sorted(comparator.reversed()).toList();
    }

}
