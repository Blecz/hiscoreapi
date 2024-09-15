package com.lopan.hiscoreApi.domain.score;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ScoreRepository {

    public Score saveScore(Score score);
    public List<Score> listScore(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField);
}
