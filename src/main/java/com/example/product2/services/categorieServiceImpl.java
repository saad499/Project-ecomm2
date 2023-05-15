package com.example.product2.services;

import com.example.product2.DTO.CategorieDTO;
import com.example.product2.entities.Categorie;
import com.example.product2.repositories.categorieRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@AllArgsConstructor
@Transactional
public class categorieServiceImpl implements categorieService{

    private categorieRepository categorieRepository;
    @KafkaListener(topics = "categorie")
    public Categorie ajouterCategorie(Categorie categorie) {
        categorie.setCreatedAt(new Date());
        Categorie saveCategorie = categorieRepository.save(categorie);
        return saveCategorie;
    }

    @KafkaListener(topics = "categorie")
    public Categorie modifierCategorie(Categorie categorie) {
        categorie.setUpdatedAt(new Date());
        Categorie categories = categorieRepository.save(categorie);
        return categories;
    }
    @KafkaListener(topics = "categorie")
    public Categorie modifierLigne(CategorieDTO categorieDTO) {
        Categorie categorie = categorieRepository.findById(categorieDTO.getId()).orElseThrow();
        categorie.setSupprimer(true);
        categorieRepository.save(categorie);
        return categorie;
    }

}
