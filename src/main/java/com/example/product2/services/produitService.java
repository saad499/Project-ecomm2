package com.example.product2.services;

import com.example.product2.DTO.ProduitDTO;
import com.example.product2.entities.Produit;
import org.springframework.data.domain.Page;

public interface produitService {
    Produit ajouterProduit(Produit produit);
   /* Produit modifierProduit(Produit produit);*/
    Produit modifierLigne(ProduitDTO produitDTO);

}
