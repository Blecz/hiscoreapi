package com.lopan.hiscoreApi.domain.score;

import com.lopan.hiscoreApi.domain.score.dto.ScoreWrapperDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public interface ScoreService {

    public List<Score> saveScores(ScoreWrapperDTO score);
    public List<Score> topScores(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField, Boolean isAscending);

}
