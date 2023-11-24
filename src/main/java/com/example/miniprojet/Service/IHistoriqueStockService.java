package com.example.miniprojet.Service;

import com.example.miniprojet.Entity.HistoriqueStock;

import java.util.List;

public interface IHistoriqueStockService {
    List<HistoriqueStock> getAllHistoriqueStocks();
    HistoriqueStock getHistoriqueStockById(Long id);
    HistoriqueStock saveHistoriqueStock(HistoriqueStock historiqueStock);
    void deleteHistoriqueStock(Long id);
}
