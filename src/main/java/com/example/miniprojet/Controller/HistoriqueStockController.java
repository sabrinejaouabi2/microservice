package com.example.miniprojet.Controller;

import com.example.miniprojet.Entity.HistoriqueStock;
import com.example.miniprojet.Service.IHistoriqueStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/historiqueStocks")
public class HistoriqueStockController {
    @Autowired
    private IHistoriqueStockService historiqueStockService;

    @GetMapping

    public List<HistoriqueStock> getAllHistoriqueStocks() {
        return historiqueStockService.getAllHistoriqueStocks();
    }

    @GetMapping("/{id}")

    public HistoriqueStock getHistoriqueStockById(@PathVariable Long id) {
        return historiqueStockService.getHistoriqueStockById(id);
    }

    @PostMapping

    public HistoriqueStock createHistoriqueStock(@RequestBody HistoriqueStock historiqueStock) {
        return historiqueStockService.saveHistoriqueStock(historiqueStock);
    }

    @DeleteMapping("/{id}")

    public void deleteHistoriqueStock(@PathVariable Long id) {
        historiqueStockService.deleteHistoriqueStock(id);
    }
}
