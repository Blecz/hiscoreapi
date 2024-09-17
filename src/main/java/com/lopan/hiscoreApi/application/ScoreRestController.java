package com.lopan.hiscoreApi.application;

import com.lopan.hiscoreApi.domain.score.Score;
import com.lopan.hiscoreApi.domain.score.ScoreService;
import com.lopan.hiscoreApi.domain.score.ScoreWrapperDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
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
                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                     @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime endDate,
                                     @RequestParam(required = false) String sortingField,
                                     @RequestParam(required = false) Boolean isAscending)
    {
        return service.topScores(gameId, startDate, endDate, sortingField, isAscending);
    }

}
