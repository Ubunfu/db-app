package ninja.ryanallen.dbapp;

import ninja.ryanallen.dbapp.entity.Account;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT)
public class AccountsFunctionalTest {

    private static final String URI_ACCOUNT = "/account";
    private static final String URI_ACCOUNTS = "/accounts";
    private static final String URI_PARAM_EMAIL = "?email=";
    private static final String ACCOUNT_1_EMAIL = "rallen@email.com";
    private static final String ACCOUNT_1_USERNAME = "ryan";
    private static final String ACCOUNT_2_EMAIL = "angela@email.com";
    private static final String ACCOUNT_2_USERNAME = "angela";
    private static final Account ACCOUNT_1 = new Account(ACCOUNT_1_USERNAME, ACCOUNT_1_EMAIL);
    private static final Account ACCOUNT_2 = new Account(ACCOUNT_2_USERNAME, ACCOUNT_2_EMAIL);

    private final TestRestTemplate testRestTemplate;

    @Autowired
    public AccountsFunctionalTest(TestRestTemplate testRestTemplate) {
        this.testRestTemplate = testRestTemplate;
    }

    @Test
    void getAccountReturnsOneAccount() {
        createTestAccount(ACCOUNT_1);
        ResponseEntity<Account> response = testRestTemplate
                .getForEntity(URI_ACCOUNT + URI_PARAM_EMAIL + ACCOUNT_1_EMAIL, Account.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        Account respAccount = response.getBody();
        assertNotNull(respAccount);
        assertThat(respAccount.getEmail(), equalTo(ACCOUNT_1_EMAIL));
        assertThat(respAccount.getUsername(), equalTo(ACCOUNT_1_USERNAME));
    }

    @Test
    void getAccountsReturnsMultipleAccounts() {
        createTestAccount(ACCOUNT_2);
        ResponseEntity<List> response = testRestTemplate.getForEntity(URI_ACCOUNTS, List.class);
        assertThat(response.getStatusCode(), is(HttpStatus.OK));

        List<Account> accounts = response.getBody();
        assertNotNull(accounts);
        assertThat(accounts, hasSize(greaterThan(0)));
    }

    private void createTestAccount(Account testAccount) {
        testRestTemplate.postForEntity(URI_ACCOUNT, testAccount, Account.class);
    }
}
