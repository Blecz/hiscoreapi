package com.lopan.hiscoreApi.domain.score;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Getter
public class Score {

    private UUID gameId;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String gameKey;
    private Map<String, String> score;
    private LocalDate timestamp;

    public Score(UUID gameId, String gameKey, Map<String, String> score) {
        this.gameId = gameId;
        this.gameKey = gameKey;
        this.score = score;
        this.timestamp = LocalDate.now();
    }

}
