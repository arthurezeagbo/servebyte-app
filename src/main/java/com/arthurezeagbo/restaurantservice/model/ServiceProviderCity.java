package com.arthurezeagbo.restaurantservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
//@Entity(name = "service_provider_city")
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServiceProviderCity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "service_provider_id")
    private Long serviceProviderId;

    @Column(name = "city_id")
    private Long cityId;

    public ServiceProviderCity(Long serviceProviderId,Long cityId){
        this.serviceProviderId = serviceProviderId;
        this.cityId = cityId;
    }
}
