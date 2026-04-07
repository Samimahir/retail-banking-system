package com.mahir.retailbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mahir.retailbanking.model.Transaction;
import com.mahir.retailbanking.service.TransactionService;
import java.util.List;

@RestController
<<<<<<< HEAD
@RequestMapping("/api/transactions")
@CrossOrigin(origins = "http://localhost:3000")
=======
@RequestMapping("/api")
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

<<<<<<< HEAD
    @PostMapping("/")
=======
    @PostMapping("/transaction")
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
    public Transaction saveTransaction(@RequestBody Transaction transaction) {
        return transactionService.saveTransaction(transaction);
    }

<<<<<<< HEAD
    // Unique path for account transactions
    @GetMapping("/account/{accountNumber}")
    public List<Transaction> getTransactionsByAccount(@PathVariable String accountNumber) {
=======
    @GetMapping("/transactions/{accountNumber}")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
        return transactionService.getTransactions(accountNumber);
    }
}