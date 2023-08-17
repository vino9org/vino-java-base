package net.vino9.vino.demo.data.model;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Getter
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    Long id;

    String customerId;
    String name;
    CustomerStatus status;
}

enum CustomerStatus {
    ACTIVE,
    INACTIVE
}

// DELETE_IF: cookiecutter.database_type != 'postgresql' and cookiecutter.database_type != 'mysql'
