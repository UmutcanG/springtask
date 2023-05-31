package com.beam.task.account;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends MongoRepository<Account,String> {
    Account findByName(String name);

    boolean existsByAdmin(boolean admin);



}
