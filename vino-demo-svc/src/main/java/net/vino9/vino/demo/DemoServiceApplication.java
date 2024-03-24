// spotless:off
package net.vino9.vino.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// CC: {% if cookiecutter.cache_type != 'none' -%}
import org.springframework.cache.annotation.EnableCaching;
// CC: {% endif -%}
// CC: {% if cookiecutter.database_type == 'postgresql' or cookiecutter.database_type == 'mysql' -%}
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
// CC: {% endif -%}
// CC: {% if cookiecutter.database_type == 'mongodb' -%}
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

// CC: {% endif -%}

@SpringBootApplication
// CC: {% if cookiecutter.database_type == 'mongodb' -%}
@EnableMongoRepositories
// CC: {% endif -%}
// CC: {% if cookiecutter.cache_type != 'none' -%}
@EnableCaching
// CC: {% endif -%}
// CC: {% if cookiecutter.database_type == 'postgresql' or cookiecutter.database_type == 'mysql' -%}
@EnableJpaRepositories
// CC: {% endif -%}
public class DemoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoServiceApplication.class, args);
    }
}
// spotless:on
