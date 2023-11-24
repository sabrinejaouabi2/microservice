package com.example.miniprojet.Controller;

import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Entity.Stock;
import com.example.miniprojet.Service.IEmplacementService;
import com.example.miniprojet.Service.IstockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/stocks")

public class StockController {
    @Autowired
    private IstockService stockService;
    @Autowired
    private IEmplacementService emplacementService;


    @GetMapping

    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")

    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping

    public Stock createStock(@RequestBody Stock stock) {
        return stockService.saveStock(stock);
    }

    @DeleteMapping("/{id}")

    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }


    @GetMapping("/quantiteTotaleProduits")
    public ResponseEntity<Integer> getQuantiteTotaleProduits() {
        int quantiteTotale = stockService.calculerQuantiteTotaleProduits();
        return new ResponseEntity<>(quantiteTotale, HttpStatus.OK);
    }

    @GetMapping("/calculerStockActuel/{idEmplacement}")
    public ResponseEntity<Integer> calculerStockActuel(@PathVariable Long idEmplacement) {
        Emplacement emplacement = emplacementService.getEmplacementById(idEmplacement);

        if (emplacement == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        int stockActuel = stockService.calculerStockActuel(emplacement);
        return new ResponseEntity<>(stockActuel, HttpStatus.OK);
    }

    @PostMapping("/ajouterQuantite/{idStock}/{quantiteAjoutee}")
    public ResponseEntity<Void> ajouterQuantite(@PathVariable Long idStock, @PathVariable int quantiteAjoutee) {
        Stock stock = stockService.getStockById(idStock);

        if (stock == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        stockService.ajouterQuantite(stock, quantiteAjoutee);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
