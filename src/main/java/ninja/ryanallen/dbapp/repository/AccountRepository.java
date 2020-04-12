package ninja.ryanallen.dbapp.repository;

import ninja.ryanallen.dbapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findOneByEmail(String email);
}
