package com.tiberiu.pharmacy.service;

import com.tiberiu.pharmacy.exception.TransactionNotFoundException;
import com.tiberiu.pharmacy.model.Client;
import com.tiberiu.pharmacy.model.Medicine;
import com.tiberiu.pharmacy.model.Transaction;
import com.tiberiu.pharmacy.repository.ClientRepository;
import com.tiberiu.pharmacy.repository.MedicineRepository;
import com.tiberiu.pharmacy.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private MedicineRepository medicineRepository;

    public Transaction findOne(Integer id) throws TransactionNotFoundException {
        Optional<Transaction> optTransaction = transactionRepository.findById(id);

        if (optTransaction.isPresent()) {
            return optTransaction.get();
        }

        throw new TransactionNotFoundException("Transaction not found");
    }

    public List<Transaction> findAll() {
        return transactionRepository.findAll();
    }

    public Transaction save(Transaction transaction) {
        Client client = transaction.getClient();
        Integer clientId = client.getId();
        if (clientId != null && clientRepository.findById(clientId).isPresent()) {
            transaction.setClient(clientRepository.findById(clientId).get());
        }

        Set<Medicine> medicines = transaction.getMedicines();

        medicineRepository.saveAll(medicines);
        return transactionRepository.save(transaction);
    }

    public void delete(Integer id) {
        transactionRepository.deleteById(id);
    }
}
