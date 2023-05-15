package com.example.product2.mapper;

import com.example.product2.DTO.CategorieDTO;
import com.example.product2.DTO.ProduitDTO;
import com.example.product2.entities.Categorie;
import com.example.product2.entities.Produit;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class productMapperImpl {
    public ProduitDTO fromProduit(Produit produit){
        ProduitDTO produitDTO = new ProduitDTO();
        BeanUtils.copyProperties(produit, produitDTO);
        return produitDTO;
    }

    public Produit fromProduitDTO(ProduitDTO produitDTO){
        Produit produit = new Produit();
        BeanUtils.copyProperties(produitDTO, produit);
        return produit;
    }

    public CategorieDTO fromCategorie(Page<Categorie> categorie){
        CategorieDTO categorieDTO = new CategorieDTO();
        BeanUtils.copyProperties(categorie,categorieDTO);
        return categorieDTO;
    }

    public Categorie fromCategorieDTO(CategorieDTO categorieDTO){
        Categorie categorie = new Categorie();
        BeanUtils.copyProperties(categorieDTO, categorie);
        return categorie;
    }
}
