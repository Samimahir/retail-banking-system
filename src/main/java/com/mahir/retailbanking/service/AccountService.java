package com.mahir.retailbanking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mahir.retailbanking.model.Account;
import com.mahir.retailbanking.model.Transaction;
import com.mahir.retailbanking.repository.AccountRepository;
import com.mahir.retailbanking.repository.TransactionRepository;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    public double getBalance(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber);
        return account != null ? account.getBalance() : 0;
    }

    public void deposit(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);

            transactionRepository.save(
                    new Transaction(accountNumber, "Deposit", amount)
            );
        }
    }

    public void withdraw(String accountNumber, double amount) {
        Account account = accountRepository.findByAccountNumber(accountNumber);

        if (account != null && account.getBalance() >= amount) {
            account.setBalance(account.getBalance() - amount);
            accountRepository.save(account);

            transactionRepository.save(
                    new Transaction(accountNumber, "Withdraw", amount)
            );
        }
    }

    public String transfer(String fromAccount, String toAccount, double amount) {

        Account sender = accountRepository.findByAccountNumber(fromAccount);
        Account receiver = accountRepository.findByAccountNumber(toAccount);

        if (sender == null || receiver == null) {
            return "Account not found";
        }

        if (sender.getBalance() < amount) {
            return "Insufficient balance";
        }

        sender.setBalance(sender.getBalance() - amount);
        receiver.setBalance(receiver.getBalance() + amount);

        accountRepository.save(sender);
        accountRepository.save(receiver);

        transactionRepository.save(
                new Transaction(fromAccount, "Transfer Sent", amount)
        );

        transactionRepository.save(
                new Transaction(toAccount, "Transfer Received", amount)
        );

        return "Transfer Success";
    }
}