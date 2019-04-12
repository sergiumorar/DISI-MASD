package com.masd.masd.repository;

import com.masd.masd.model.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Marina Baban
 */

@Repository
public interface JpaAccountRepository extends CrudRepository<Account, Integer> {
}
