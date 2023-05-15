package com.example.product2.DTO;

import com.example.product2.entities.Categorie;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.Date;

@Data @Component
public class ProduitDTO {
    private Long id;
    private String nom;
    private String description;
    private String image;
    private String slug;
    private Date createdAt;
    private Date updatedAt;
    private  boolean supprimer;
    private Categorie categorie;
}
