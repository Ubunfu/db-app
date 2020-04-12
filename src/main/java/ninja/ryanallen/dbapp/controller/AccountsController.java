package ninja.ryanallen.dbapp.controller;

import ninja.ryanallen.dbapp.entity.Account;
import ninja.ryanallen.dbapp.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountsController {

    @Autowired
    private AccountsService accountsService;

    @GetMapping("/accounts")
    public List<Account> getAccounts() {
        return accountsService.getAllAccounts();
    }

    @GetMapping("/account")
    public Account getAccount(@RequestParam String email) {
        return accountsService.getAccount(email);
    }

    @PostMapping("/account")
    public void createAccount(@RequestBody Account account) {
        accountsService.addAccount(account);
    }
}
