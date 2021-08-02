package com.arthurezeagbo.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Blob;
import java.time.LocalTime;

@Data
@Entity
@NoArgsConstructor
public class Meal{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Blob picture;
    private double price;
    private LocalTime preparationTime;

    private String description;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;


    public Meal(Blob picture, double price, LocalTime preparationTime, String description){
        this.picture = picture;
        this.price = price;
        this.preparationTime = preparationTime;
        this.description = description;
    }
}
