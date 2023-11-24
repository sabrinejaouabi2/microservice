package com.example.miniprojet.Controller;

import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Service.IEmplacementService;
import com.itextpdf.text.DocumentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emplacements")
public class EmplacementController {
    @Autowired
    private IEmplacementService emplacementService;

    @GetMapping

    public List<Emplacement> getAllEmplacements() {
        return emplacementService.getAllEmplacements();
    }

    @GetMapping("/{id}")

    public Emplacement getEmplacementById(@PathVariable Long id) {
        return emplacementService.getEmplacementById(id);
    }

    @PostMapping

    public Emplacement createEmplacement(@RequestBody Emplacement emplacement) {
        return emplacementService.saveEmplacement(emplacement);
    }

    @DeleteMapping("/{id}")

    public void deleteEmplacement(@PathVariable Long id) {
        emplacementService.deleteEmplacement(id);
    }


    @GetMapping("/generatePdfForEmplacements")
    public ResponseEntity<byte[]> generatePdfForEmplacements() {
        try {
            List<Emplacement> emplacements = emplacementService.getAllEmplacements();
            byte[] pdfBytes = emplacementService.generatePdfForEmplacements(emplacements);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.parseMediaType("application/pdf"));
            headers.setContentDispositionFormData("attachment", "liste_emplacements.pdf");

            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);

        } catch (DocumentException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
