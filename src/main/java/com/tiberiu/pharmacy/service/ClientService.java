package com.tiberiu.pharmacy.service;

import com.tiberiu.pharmacy.exception.ClientNotFoundException;
import com.tiberiu.pharmacy.model.Client;
import com.tiberiu.pharmacy.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    /*
    1. Find one
    2. Find all
    3. Save one
     */

    public Client findOne(Integer id) throws ClientNotFoundException {
        Optional<Client> optClient = clientRepository.findById(id);

        if (optClient.isPresent()) {
           return optClient.get();
        }

        throw new ClientNotFoundException("Client not found");
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public Client save(Client client) {
        return clientRepository.save(client);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }

    public List<Client> findBySales(Integer cardSales) {
        return clientRepository.findByCardSalesGreaterThan(cardSales);
    }
}
