package com.example.miniprojet.Service;

import com.example.miniprojet.Entity.Emplacement;
import com.itextpdf.text.DocumentException;

import java.util.List;

public interface IEmplacementService {
    List<Emplacement> getAllEmplacements();
    Emplacement getEmplacementById(Long id);
    Emplacement saveEmplacement(Emplacement emplacement);
    void deleteEmplacement(Long id);
     byte[] generatePdfForEmplacements(List<Emplacement> emplacements) throws DocumentException;


}
