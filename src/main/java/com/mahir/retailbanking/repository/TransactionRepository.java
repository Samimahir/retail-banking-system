package com.mahir.retailbanking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import com.mahir.retailbanking.model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> findByAccountNumber(String accountNumber);
}