package com.lopan.hiscoreApi.domain.score;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
public class Score {

    private UUID gameId;
    private Map<String, String> scoreInfo;
    private LocalDateTime timestamp;

    public Score(UUID gameId, Map<String, String> scoreInfo) {
        this.gameId = gameId;
        this.scoreInfo = scoreInfo;
        this.timestamp = LocalDateTime.now();
    }

}
