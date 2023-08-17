package net.vino9.vino.demo.data.repository;

import java.util.List;

import net.vino9.vino.demo.data.model.CasaAccount;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CasaAccountRepository extends MongoRepository<CasaAccount, String> {
    @Query("{ 'accountId' : ?0 }")
    CasaAccount findByAccountId(String accountId);

    @Query("{ 'customerId' : ?0 }")
    List<CasaAccount> findByCustomerId(String customerId);
}

// DELETE_IF: cookiecutter.database_type != 'mongodb'
