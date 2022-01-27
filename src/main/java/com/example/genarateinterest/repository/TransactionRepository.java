package com.example.genarateinterest.repository;

import com.example.genarateinterest.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findFirst10ByAccount_AccountNoAndAccount_Customer_Id(String accountNo, long custId);
}
