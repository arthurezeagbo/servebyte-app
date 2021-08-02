package com.arthurezeagbo.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Entity(name = "service_provider_meal")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProviderMeal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service_provider_id")
    private Long serviceProviderId;

    @Column(name = "meal_id")
    private Long mealId;

    public ServiceProviderMeal(Long serviceProviderId, Long mealId){
        this.serviceProviderId = serviceProviderId;
        this.mealId = mealId;
    }

}
