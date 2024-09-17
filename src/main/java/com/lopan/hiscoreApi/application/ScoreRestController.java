package com.lopan.hiscoreApi.application;

import com.lopan.hiscoreApi.domain.score.Score;
import com.lopan.hiscoreApi.domain.score.ScoreService;
import com.lopan.hiscoreApi.domain.score.dto.ScoreWrapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/scores", produces = MediaType.APPLICATION_JSON_VALUE)
public class ScoreRestController {

    private ScoreService service;

    @Autowired
    public ScoreRestController(ScoreService service) {
        this.service = service;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Score> saveScores(@RequestBody ScoreWrapperDTO score) {
        return service.saveScores(score);
    }

    @GetMapping("/{gameId}")
    public List<Score> listTopScores(@PathVariable UUID gameId,
                                     @RequestParam(required = false) LocalDate startDate,
                                     @RequestParam(required = false) LocalDate endDate,
                                     @RequestParam(required = false) String sortingField,
                                     @RequestParam(required = false) Boolean isAscending)
    {
        return service.topScores(gameId, startDate, endDate, sortingField, isAscending);
    }

}
