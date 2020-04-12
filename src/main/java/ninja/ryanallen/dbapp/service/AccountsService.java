package ninja.ryanallen.dbapp.service;

import ninja.ryanallen.dbapp.entity.Account;
import ninja.ryanallen.dbapp.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AccountsService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountsService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccount(String email) {
        return accountRepository.findOneByEmail(email);
    }

    public void addAccount(Account account) {
        accountRepository.save(account);
    }
}
