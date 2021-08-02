package com.arthurezeagbo.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @OneToMany(mappedBy = "city")
    private List<ServiceProvider> serviceProviders;

    public City(String name){
        this.name = name;
    }


}
