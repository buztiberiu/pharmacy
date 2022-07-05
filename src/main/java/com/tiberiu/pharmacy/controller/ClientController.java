package com.tiberiu.pharmacy.controller;

import com.tiberiu.pharmacy.exception.ClientNotFoundException;
import com.tiberiu.pharmacy.model.Client;
import com.tiberiu.pharmacy.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("clients", clientService.findAll());
        model.addAttribute("client", new Client());
        return "index";
    }

    @GetMapping("/{id}")
    public Client findOne(@PathVariable Integer id) {
        try {
            return clientService.findOne(id);
        } catch (ClientNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage(), e);
        }
    }

    @PostMapping
    public String saveClient(Client client, BindingResult result, Model model) {
        clientService.save(client);
        return "redirect:/clients";
    }

    @DeleteMapping("/{id}")
    public void deleteClient(@PathVariable Integer id) {
        clientService.delete(id);
    }

    @GetMapping("/clients/{cardSales}")
    public List<Client> findByCardSalesGreaterThan(@PathVariable Integer cardSales) {
        return clientService.findBySales(cardSales);
    }

    //sa fac si pt drugs ce am facut pt client
    // informatiile sa le pun intr-un tabel
}
