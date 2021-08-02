package com.arthurezeagbo.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.sql.Blob;
import java.util.List;


@Data
@Entity
@NoArgsConstructor
public class ServiceProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @Email
    private String email;

    private Blob logo;

    @Column(name = "phone_number")
    private String phoneNumber;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @JsonManagedReference
    @LazyCollection(LazyCollectionOption.FALSE)
    @EqualsAndHashCode.Exclude @ToString.Exclude
    @OneToMany(mappedBy = "serviceProvider")
    private List<Meal> meals;

    public ServiceProvider(String name, String email, Blob logo, String phoneNumber){
        this.name = name;
        this.email = email;
        this.logo = logo;
        this.phoneNumber = phoneNumber;
    }

}
