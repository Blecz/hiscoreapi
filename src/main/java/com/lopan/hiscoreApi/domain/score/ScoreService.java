package com.lopan.hiscoreApi.domain.score;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface ScoreService {

    public List<Score> saveScores(ScoreWrapperDTO score);
    public List<Score> topScores(UUID gameId, LocalDateTime startDate, LocalDateTime endDate, String sortingField, Boolean isAscending);

}
