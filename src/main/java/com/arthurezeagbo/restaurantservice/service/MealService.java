package com.arthurezeagbo.restaurantservice.service;

import com.arthurezeagbo.restaurantservice.model.Meal;
import com.arthurezeagbo.restaurantservice.model.ServiceProvider;

import java.util.Optional;

public interface MealService {

    Optional<Meal> getMealById(Long mealId);

}
