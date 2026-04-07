package com.mahir.retailbanking.model;

import jakarta.persistence.*;
<<<<<<< HEAD
import java.time.LocalDateTime;
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3

@Entity
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accountNumber;
    private String type;
    private double amount;
<<<<<<< HEAD
    private LocalDateTime time;
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3

    public Transaction() {}

    public Transaction(String accountNumber, String type, double amount) {
        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
<<<<<<< HEAD
        this.time = LocalDateTime.now();
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
<<<<<<< HEAD

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }
=======
>>>>>>> 2edd4d82b118aaa9095aa9ae65d5fe80666111b3
}