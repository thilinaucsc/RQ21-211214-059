package com.example.genarateinterest.repository;

import com.example.genarateinterest.entity.Account;
import com.example.genarateinterest.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<List<Account>> getAllByTerminatedDateIsNull();

    Optional<List<Account>> getAllByTerminatedDateIsNullAndAccountNoAndCustomer(String accountNo, Customer customer);
}
