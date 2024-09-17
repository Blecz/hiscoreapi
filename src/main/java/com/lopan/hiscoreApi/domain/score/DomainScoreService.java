package com.lopan.hiscoreApi.domain.score;

import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameService;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DomainScoreService implements ScoreService {

    private final ScoreRepository repository;
    private final GameService gameService;

    public DomainScoreService(ScoreRepository repository, GameService gameService) {
        this.repository = repository;
        this.gameService = gameService;
    }

    @Override
    public List<Score> saveScores(ScoreWrapperDTO score) {
        Game game = gameService.getGame(score.getGameId());
        if (!game.getKey().equals(score.getGameKey())) {
            throw new RuntimeException("Invalid game key");
        }

        return repository.saveScores(scoreInfoToScores(score));
    }

    @Override
    public List<Score> topScores(UUID gameId, LocalDateTime startDate, LocalDateTime endDate, String sortingField, Boolean isAscending) {
        if (startDate == null)
            startDate = LocalDateTime.now().minus(30, ChronoUnit.DAYS);

        if (endDate == null)
            endDate = LocalDateTime.now();

        Game game;
        if (sortingField == null || isAscending == null) {
            game = gameService.getGame(gameId);
            if (sortingField == null) sortingField = game.getDefaultSortingField();
            if (isAscending == null) isAscending = game.isAscending();
        }

        return repository.listScore(gameId, startDate, endDate, sortingField, isAscending);
    }

    private List<Score> scoreInfoToScores(ScoreWrapperDTO scoreWrapperDTO) {
        return scoreWrapperDTO.getScoreInfos().stream()
                .map(info -> new Score(scoreWrapperDTO.getGameId(), info))
                .collect(Collectors.toList());
    }

}
