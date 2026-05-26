package com.example; // Double check this matches your exact package name

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/transactions") // Base URL for all transaction endpoints
public class TransactionController {

    @Autowired
    private TransactionRepository transactionRepository; // Wires up your database gateway

    // 1. GET ALL TRANSACTIONS: Pulls data from database to show on your frontend
    @GetMapping
    public List<Transaction> getAllTransactions() {
        return transactionRepository.findAll();
    }

    // 2. CREATE A TRANSACTION: Receives new finance entries and saves them to the database
    @PostMapping
    public Transaction createTransaction(@RequestBody Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    // 3. DELETE A TRANSACTION: Removes a transaction from the database by its ID
    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        transactionRepository.deleteById(id);
    }
}