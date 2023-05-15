package com.example.product2.services;

import com.example.product2.DTO.ProduitDTO;
import com.example.product2.entities.Produit;
import com.example.product2.mapper.productMapperImpl;
import com.example.product2.repositories.produitRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service @Slf4j
public class produitServiceImpl implements produitService{

    private final produitRepository produitRepository;
    private final KafkaTemplate<String, Produit> kafkaTemplate;

    public produitServiceImpl(com.example.product2.repositories.produitRepository produitRepository, KafkaTemplate<String, Produit> kafkaTemplate) {
        this.produitRepository = produitRepository;
        this.kafkaTemplate = kafkaTemplate;
    }

    @KafkaListener(topics = "produit", containerFactory = "kafkaListenerContainerFactory2")
    public Produit ajouterProduit(Produit produit) {
        log.info("Product is saved {} ", produit);
        Produit produits = produitRepository.save(produit);
        return produits;
    }
/*
    @KafkaListener(topics = "produit", containerFactory = "kafkaListenerContainerFactory2")
    public Produit modifierProduit(Produit produit) {
        Produit produits = produitRepository.save(produit);
        return produits;
    }
*/
    @KafkaListener(topics = "produit", containerFactory = "kafkaListenerContainerFactory2")
    public Produit modifierLigne(ProduitDTO produitDTO) {
        log.info("Product is updated {} ", produitDTO);
        Produit produits = produitRepository.findById(produitDTO.getId()).orElseThrow();
        produitRepository.save(produits);
        return produits;
    }


}
