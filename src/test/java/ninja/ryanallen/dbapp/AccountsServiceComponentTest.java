package ninja.ryanallen.dbapp;

import ninja.ryanallen.dbapp.entity.Account;
import ninja.ryanallen.dbapp.service.AccountsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

@SpringBootTest
public class AccountsServiceComponentTest {

    private static final String ACCOUNT_1_EMAIL = "test@email.com";
    private static final Account ACCOUNT_1 = new Account(Long.getLong("1"), "user", ACCOUNT_1_EMAIL);

    @Autowired
    private AccountsService accountsService;

    @Test
    void addAccountAddsOneAccount() {
        accountsService.addAccount(ACCOUNT_1);
        assertThat(accountsService.getAllAccounts(), hasSize(1));
        assertThat(accountsService.getAccount(ACCOUNT_1_EMAIL).getEmail(), equalTo(ACCOUNT_1_EMAIL));
    }
}
