package com.arthurezeagbo.restaurantservice.service;

import com.arthurezeagbo.restaurantservice.model.ServiceProvider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface RestaurantService extends MealService {

    Optional<ServiceProvider> getRestaurantById(Long resturantId);

    List<ServiceProvider> getRestaurantsByCityId(Long citiId);

}
