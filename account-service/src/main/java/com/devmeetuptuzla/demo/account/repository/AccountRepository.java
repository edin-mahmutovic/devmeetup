package com.devmeetuptuzla.demo.account.repository;

import com.devmeetuptuzla.demo.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAccountByCustomerId(String customerId);

    @Modifying
    @Query("update Account a set a.balance = a.balance + :amount where a.id = :accountId")
    int updateAccountBalance(@Param("accountId") Long accountId, @Param("amount") Double amount);
}
