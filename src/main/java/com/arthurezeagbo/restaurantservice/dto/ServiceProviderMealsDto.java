package com.arthurezeagbo.restaurantservice.dto;

import com.arthurezeagbo.restaurantservice.model.Meal;
import com.arthurezeagbo.restaurantservice.model.ServiceProvider;
import lombok.Data;

import javax.validation.constraints.Email;
import java.sql.Blob;
import java.util.List;

@Data
public class ServiceProviderMealsDto {

    private Long id;
    private String name;
    private String email;
    private String city;

    private Blob logo;
    private String phoneNumber;

    private List<Meal> mealList;

}
