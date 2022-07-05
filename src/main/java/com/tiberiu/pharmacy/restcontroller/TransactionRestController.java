package com.tiberiu.pharmacy.restcontroller;

import com.tiberiu.pharmacy.exception.TransactionNotFoundException;
import com.tiberiu.pharmacy.model.Transaction;
import com.tiberiu.pharmacy.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/transactions")
public class TransactionRestController {

    @Autowired
    private TransactionService transactionService;

    @GetMapping
    public List<Transaction> findAll() {
        return transactionService.findAll();
    }

    @GetMapping("/{id}")
    public Transaction findOne(@PathVariable Integer id) {
        try {
            return transactionService.findOne(id);
        } catch (TransactionNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/transactions")
    public Transaction saveTransaction(final @RequestBody Transaction transaction) {
        return transactionService.save(transaction);
    }

    @DeleteMapping("/{id}")
    public void deleteTransaction(@PathVariable Integer id) {
        transactionService.delete(id);
    }
}
