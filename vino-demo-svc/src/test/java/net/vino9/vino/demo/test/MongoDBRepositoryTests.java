package net.vino9.vino.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.vino9.vino.demo.data.repository.CasaAccountRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class MongoDBRepositoryTests {

    @Autowired CasaAccountRepository accountRepository;

    @Test
    void canReadAccounts() {
        var accounts = accountRepository.findAll();
        assertEquals(2, accounts.size());
        assertEquals("111", accounts.get(0).getCustomerId());
    }
}

// DELETE_IF: cookiecutter.database_type != 'mongodb'
