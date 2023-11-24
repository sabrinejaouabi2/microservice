package com.example.miniprojet.Repository;

import com.example.miniprojet.Entity.Emplacement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmplacementRepository extends JpaRepository<Emplacement, Long> {
    // Ajoute des méthodes personnalisées si nécessaire
}