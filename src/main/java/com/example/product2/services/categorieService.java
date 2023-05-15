package com.example.product2.services;

import com.example.product2.DTO.CategorieDTO;
import com.example.product2.entities.Categorie;
import org.springframework.data.domain.Page;

public interface categorieService {

    Categorie ajouterCategorie(Categorie categorie);
    Categorie modifierCategorie(Categorie categorie);

    Categorie modifierLigne(CategorieDTO categorieDTO);
}
