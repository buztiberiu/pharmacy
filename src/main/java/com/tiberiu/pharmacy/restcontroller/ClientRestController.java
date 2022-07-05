package com.tiberiu.pharmacy.restcontroller;

import com.tiberiu.pharmacy.exception.ClientNotFoundException;
import com.tiberiu.pharmacy.model.Client;
import com.tiberiu.pharmacy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/rest/clients")
public class ClientRestController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findOne(@PathVariable Integer id) {
        try {
            return clientService.findOne(id);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping("/clients")
    public Client saveClient(final @RequestBody Client client) {
        return clientService.save(client);
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }

    @GetMapping("/clients/{cardSales}")
    public List<Client> findByCardSalesGreaterThan(@PathVariable Integer cardSales) {
        return clientService.findBySales(cardSales);
    }
}
