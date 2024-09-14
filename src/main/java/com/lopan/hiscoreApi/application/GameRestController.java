package com.lopan.hiscoreApi.application;

import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameRestController {

    private GameService service;

    @Autowired
    public GameRestController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> findGames(@RequestParam(required = false) String name) {
        return service.findGames(name);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Game createGame(@RequestBody Game game) {
        return service.createGame(game);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Game updateGame(@RequestBody Game game) {
        return service.updateGame(game);
    }

}
