package ninja.ryanallen.dbapp.controller;

import ninja.ryanallen.dbapp.entity.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class GamesController {

    @Autowired
    @Qualifier("games")
    private ReactiveMongoTemplate gamesMongoTemplate;

    @GetMapping("/games")
    public Flux<? extends Game> getGames() {
        return gamesMongoTemplate.findAll(Game.class);
    }

    @PostMapping("/game")
    public Mono<? extends Game> createGame(@RequestBody Game game) {
        return gamesMongoTemplate.save(game);
    }
}
