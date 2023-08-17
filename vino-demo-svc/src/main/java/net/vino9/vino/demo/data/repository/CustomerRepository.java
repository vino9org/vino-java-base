package net.vino9.vino.demo.data.repository;

import net.vino9.vino.demo.data.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, String> {}
// DELETE_IF: cookiecutter.database_type != 'postgresql' and cookiecutter.database_type != 'mysql'
