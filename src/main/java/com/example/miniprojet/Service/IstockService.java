package com.example.miniprojet.Service;

import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Entity.Stock;

import java.util.List;

public interface IstockService  {
    List<Stock> getAllStocks();
    Stock getStockById(Long id);
    Stock saveStock(Stock stock);
    void deleteStock(Long id);
    public int calculerQuantiteTotaleProduits();
    int calculerStockActuel(Emplacement emplacement);

    void enregistrerHistorique(Stock stock, int quantiteModifiee);
    void  ajouterQuantite(Stock stock, int quantiteAjoutee);
}
