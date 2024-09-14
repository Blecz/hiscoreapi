package com.lopan.hiscoreApi.application;

import com.lopan.hiscoreApi.domain.game.Game;
import com.lopan.hiscoreApi.domain.game.GameService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class GameRestController {

    private GameService service;

    @Autowired
    public GameRestController(GameService service) {
        this.service = service;
    }

    @GetMapping
    public List<Game> searchGames(@RequestParam(required = false) String name) {
        return service.searchGames(name);
    }

    @PostMapping
    public Game createGame(@RequestBody Game game) {
        return service.createGame(game);
    }

    @PutMapping
    public Game updateGame(@RequestBody Game game) {
        return service.updateGame(game);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteGame(@PathParam("id") String id) {
        service.deleteGame(id);
    }

}
