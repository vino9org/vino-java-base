package net.vino9.vino.demo.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import net.vino9.vino.demo.data.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class JpaRepositoryTests {

    @Autowired CustomerRepository customerRepository;

    @Test
    void canReadCustomers() {
        var customers = customerRepository.findAll();
        assertEquals(1, customers.size());
        assertEquals("Top one percent", customers.get(0).getName());
    }
}

// DELETE_IF: cookiecutter.database_type != 'postgresql' and cookiecutter.database_type != 'mysql'
