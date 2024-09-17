package com.lopan.hiscoreApi.domain.score;

import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameService;
import com.lopan.hiscoreApi.domain.score.dto.ScoreWrapperDTO;

import java.time.LocalDate;
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
    public List<Score> topScores(UUID gameId, LocalDate startDate, LocalDate endDate, String sortingField, Boolean isAscending) {
        return null;
    }

    private List<Score> scoreInfoToScores(ScoreWrapperDTO scoreWrapperDTO) {
        return scoreWrapperDTO.getScoreInfos().stream()
                .map(info -> new Score(scoreWrapperDTO.getGameId(), info))
                .collect(Collectors.toList());
    }

}
