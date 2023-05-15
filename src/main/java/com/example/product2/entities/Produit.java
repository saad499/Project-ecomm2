package com.example.product2.entities;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity @Builder @ToString

public class Produit implements Serializable {
    @Id
    private Long id;
    private String nom;
    private String description;
    private String image;
    private String slug;
    private Date createdAt;
    private Date updatedAt;
    private  boolean supprimer;
    @ManyToOne
    private Categorie categorie;
}
