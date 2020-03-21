package ninja.ryanallen.dbapp.controller;

import ninja.ryanallen.dbapp.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class AccountsController {

    @Autowired
    @Qualifier("accounts")
    private ReactiveMongoTemplate accountsMongoTemplate;

    @GetMapping("/accounts")
    public Flux<Account> getAccounts() {
        return accountsMongoTemplate.findAll(Account.class);
    }

    @GetMapping("/account")
    public Mono<? extends Account> getAccount(@RequestParam String id) {
        return accountsMongoTemplate.findById(id, Account.class);
    }

    @PostMapping("/account")
    public Mono<? extends Account> createAccount(@RequestBody Account account) {
        return accountsMongoTemplate.save(account);
    }
}
