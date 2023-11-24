package com.example.miniprojet.Service;
import com.example.miniprojet.Entity.Emplacement;
import com.example.miniprojet.Repository.EmplacementRepository;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.itextpdf.text.DocumentException;

import java.io.ByteArrayOutputStream;
import java.util.List;
@Service
public class EmplacementService implements IEmplacementService{
    @Autowired
    private EmplacementRepository emplacementRepository;
    @Override
    public List<Emplacement> getAllEmplacements() {
        return emplacementRepository.findAll();
    }

    @Override
    public Emplacement getEmplacementById(Long id) {
        return emplacementRepository.findById(id).orElse(null);
    }

    @Override
    public Emplacement saveEmplacement(Emplacement emplacement) {
        return emplacementRepository.save(emplacement);
    }

    @Override
    public void deleteEmplacement(Long id) {
        emplacementRepository.deleteById(id);

    }

    @Override
    public byte[] generatePdfForEmplacements(List<Emplacement> emplacements) throws DocumentException {
        if (emplacements == null || emplacements.isEmpty()) {
            // Gérer le cas où la liste d'emplacement est vide
            // Vous pouvez lever une exception, renvoyer un message d'erreur, etc.
            // Dans cet exemple, je vais simplement renvoyer un document PDF vide.
            return new byte[0];
        }

        // Créer un document PDF
        Document document = new Document();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, byteArrayOutputStream);

            document.open();

            // Ajouter le contenu au document
            document.add(new Paragraph("Liste des emplacements :"));

            for (Emplacement emplacement : emplacements) {
                document.add(new Paragraph("Nom: " + emplacement.getNom()));
                document.add(new Paragraph("Adresse: " + emplacement.getAdresse()));
                // Ajouter d'autres détails de l'emplacement selon vos besoins
                document.add(Chunk.NEWLINE);
            }

        } finally {
            if (document.isOpen()) {
                document.close();
            }
        }

        return byteArrayOutputStream.toByteArray();
    }


}



