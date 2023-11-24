package com.example.miniprojet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistoriqueStockRepository extends JpaRepository <com.example.miniprojet.Entity.HistoriqueStock, Long> {
}
