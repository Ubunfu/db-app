package ninja.ryanallen.dbapp;

import ninja.ryanallen.dbapp.entity.Account;
import ninja.ryanallen.dbapp.repository.AccountRepository;
import ninja.ryanallen.dbapp.service.AccountsService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class AccountsServiceTest {

    private static final String ACCOUNT_1_EMAIL = "test@email.com";
    private static final Account ACCOUNT_1 = new Account(Long.getLong("1"), "user", ACCOUNT_1_EMAIL);
    private List<Account> accounts;

    @Autowired
    @InjectMocks
    private AccountsService accountsService;

    @Mock
    private AccountRepository mockAccountRepository;

    @BeforeEach
    void setUp() {
        accounts = new ArrayList<>();
    }

    @Test
    void getAllAccountsReturnsList() {
        accounts.add(ACCOUNT_1);
        when(mockAccountRepository.findAll())
                .thenReturn(accounts);
        assertThat(accountsService.getAllAccounts(), hasSize(1));
        assertThat(accountsService.getAllAccounts().get(0), equalTo(ACCOUNT_1));
    }

    @Test
    void getAccountReturnsOneAccount() {
        accounts.add(ACCOUNT_1);
        when(mockAccountRepository.findOneByEmail(anyString()))
                .thenReturn(ACCOUNT_1);
        assertThat(accountsService.getAccount(ACCOUNT_1_EMAIL), equalTo(ACCOUNT_1));
    }
}
