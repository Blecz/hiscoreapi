package com.lopan.hiscoreApi.domain.score;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ScoreService {

    public Score saveScore(Score score);
    public List<Score> topScores(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField, Boolean isAscending);

}
