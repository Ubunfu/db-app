package ninja.ryanallen.dbapp.repository;

import ninja.ryanallen.dbapp.entity.Account;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends ReactiveCrudRepository<Account, String> {
}
