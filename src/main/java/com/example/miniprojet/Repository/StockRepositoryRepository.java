package com.example.miniprojet.Repository;

import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Entity.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StockRepositoryRepository extends JpaRepository<Stock, Long> {
    @Query("SELECT SUM(s.quantite) FROM Stock s")
    int calculerQuantiteTotaleProduits();

    List<Stock> findByEmplacement(Emplacement emplacement);
}