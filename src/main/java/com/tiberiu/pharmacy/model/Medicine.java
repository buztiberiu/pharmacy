package com.tiberiu.pharmacy.model;

import javax.persistence.*;

@Entity
@Table(name = "pharmacy_medicine")
public class Medicine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name="medicine_name", nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 255)
    private String producer;

    @Column(nullable = false)
    private Double price;

    @Column(nullable = false)
    private Boolean requiresRecep;

    @Column(nullable = false)
    private Integer pieces;

    @Column(nullable = false)
    private Integer sales;

    public Medicine() {

    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getRequiresRecep() {
        return requiresRecep;
    }

    public void setRequiresRecep(Boolean requiresRecep) {
        this.requiresRecep = requiresRecep;
    }

    public Integer getPieces() {
        return pieces;
    }

    public void setPieces(Integer pieces) {
        this.pieces = pieces;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }
}
