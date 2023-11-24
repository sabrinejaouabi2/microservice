package com.example.miniprojet.Service;

import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Entity.HistoriqueStock;
import com.example.miniprojet.Entity.Stock;
import com.example.miniprojet.Repository.HistoriqueStockRepository;
import com.example.miniprojet.Repository.StockRepositoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class StockService implements IstockService {
    @Autowired
    private StockRepositoryRepository stockk;
    @Autowired
    private HistoriqueStockRepository historiqueStockRepository;
    @Override
    public List<Stock> getAllStocks() {
        return stockk.findAll();
    }

    @Override
    public Stock getStockById(Long id) {
        return stockk.findById(id).orElse(null);
    }

    @Override
    public Stock saveStock(Stock stock) {
        return stockk.save(stock);
    }

    @Override
    public void deleteStock(Long id) {
        stockk.deleteById(id);

    }
    @Override
    public void ajouterQuantite(Stock stock, int quantiteAjoutee) {
        stock.setQuantite(stock.getQuantite() + quantiteAjoutee);
        stockk.save(stock);

        // Enregistre l'historique
        enregistrerHistorique(stock, quantiteAjoutee);
    }
@Override
    public int calculerQuantiteTotaleProduits() {
        return stockk.calculerQuantiteTotaleProduits();
    }

    @Override
    public int calculerStockActuel(Emplacement emplacement) {
        List<Stock> stocks = stockk.findByEmplacement(emplacement);
        return stocks.stream().mapToInt(Stock::getQuantite).sum();
    }

    @Override
    public void enregistrerHistorique(Stock stock, int quantiteModifiee) {
        HistoriqueStock historiqueStock = new HistoriqueStock(stock, new Date(), quantiteModifiee);
        historiqueStockRepository.save(historiqueStock);
    }


}
