package com.example.miniprojet.Service;

import com.example.miniprojet.Entity.HistoriqueStock;
import com.example.miniprojet.Repository.HistoriqueStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class HistoriqueStockService implements IHistoriqueStockService{
    @Autowired
    private HistoriqueStockRepository historiquStock;

    @Override
    public List<HistoriqueStock> getAllHistoriqueStocks() {
        return historiquStock.findAll();
    }

    @Override
    public HistoriqueStock getHistoriqueStockById(Long id) {
        return historiquStock.findById(id).orElse(null);
    }

    @Override
    public HistoriqueStock saveHistoriqueStock(HistoriqueStock historiqueStock) {
        return historiquStock.save(historiqueStock);
    }

    @Override
    public void deleteHistoriqueStock(Long id) {
        historiquStock.deleteById(id);

    }
}
