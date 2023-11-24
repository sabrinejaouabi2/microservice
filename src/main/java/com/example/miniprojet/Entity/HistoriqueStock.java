package com.example.miniprojet.Entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class HistoriqueStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Stock stock;

    private Date date;
    private int quantite;


    public HistoriqueStock() {
    }

    public HistoriqueStock(Stock stock, Date date, int quantite) {
        this.stock = stock;
        this.date = date;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
