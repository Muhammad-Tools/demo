package com.example.finance;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transactions")
public class TransactionController {

    private List<Transaction> transactions = new ArrayList<>();

    @GetMapping
    public List<Transaction> getAll() {
        return transactions;
    }

    @PostMapping
    public String addTransaction(@RequestBody Transaction transaction) {
        transactions.add(transaction);
        return "Transaction added";
    }

    @GetMapping("/check")
    public String check() {
        return "WORKING";
    }
}