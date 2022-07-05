package com.tiberiu.pharmacy.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "pharmacy_client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "card_number")
    private Integer cardNumber;

    @Column(name = "card_sales")
    private Integer cardSales;

    @OneToMany(mappedBy = "client")
    private Set<Transaction> transactions;

    public Client() {

    }

    public Set<Transaction> getTransactions() {
        return transactions;
    }

    public Integer getId() {
        return id;
    }

    public Integer getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Integer cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getCardSales() {
        return cardSales;
    }

    public void setCardSales(Integer cardSales) {
        this.cardSales = cardSales;
    }
}
