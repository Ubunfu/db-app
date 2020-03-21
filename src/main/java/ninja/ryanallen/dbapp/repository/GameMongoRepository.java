package ninja.ryanallen.dbapp.repository;

import ninja.ryanallen.dbapp.entity.Game;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameMongoRepository extends ReactiveMongoRepository<Game, String> {
}
