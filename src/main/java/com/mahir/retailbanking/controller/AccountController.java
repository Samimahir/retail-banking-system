package com.mahir.retailbanking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.mahir.retailbanking.model.Account;
<<<<<<< HEAD
import com.mahir.retailbanking.model.Transaction;
import com.mahir.retailbanking.service.AccountService;

import java.util.List;

=======
import com.mahir.retailbanking.service.AccountService;

>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")

public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("/account")
    public Account createAccount(@RequestBody Account account) {
        return accountService.createAccount(account);
    }

    @PutMapping("/deposit/{accountNumber}/{amount}")
    public Account depositMoney(@PathVariable String accountNumber, @PathVariable double amount) {
        return accountService.deposit(accountNumber, amount);
    }

    @PutMapping("/withdraw/{accountNumber}/{amount}")
    public Account withdrawMoney(@PathVariable String accountNumber, @PathVariable double amount) {
        return accountService.withdraw(accountNumber, amount);
    }

    @PutMapping("/transfer/{fromAccount}/{toAccount}/{amount}")
    public String transferMoney(@PathVariable String fromAccount,
                                @PathVariable String toAccount,
                                @PathVariable double amount) {
        return accountService.transfer(fromAccount, toAccount, amount);
    }

    @GetMapping("/balance/{accountNumber}")
    public double checkBalance(@PathVariable String accountNumber) {
        return accountService.checkBalance(accountNumber);
    }

    @GetMapping("/account/{accountNumber}")
    public Account getAccount(@PathVariable String accountNumber) {
        return accountService.getAccount(accountNumber);
    }
<<<<<<< HEAD

    @GetMapping("/transactions/{accountNumber}")
    public List<Transaction> getTransactions(@PathVariable String accountNumber) {
        return accountService.getTransactions(accountNumber);
    }
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
}