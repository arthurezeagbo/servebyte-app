package com.arthurezeagbo.restaurantservice.serviceImpl;

import com.arthurezeagbo.restaurantservice.model.Meal;
import com.arthurezeagbo.restaurantservice.model.ServiceProvider;
import com.arthurezeagbo.restaurantservice.repository.MealRepository;
import com.arthurezeagbo.restaurantservice.repository.ServiceProviderRepository;
import com.arthurezeagbo.restaurantservice.service.MealService;
import com.arthurezeagbo.restaurantservice.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements RestaurantService, MealService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;

    @Autowired
    private MealRepository mealRepository;

    @Override
    public Optional<ServiceProvider> getRestaurantById(Long resturantId) {
        return serviceProviderRepository.findById(resturantId);
    }

    @Override
    public List<ServiceProvider> getRestaurantsByCityId(Long citiId) {

        //This is going to be expensive. It's better handled at the once at the database level
        // maybe using native query or stored procedure, but I may come back to it.
        // Something came up that I have to travel which made me come back late on this assessment
        return serviceProviderRepository.findAll()
                .stream().filter(c -> c.getCity().getId() == citiId)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Meal> getMealById(Long mealId) {
        return mealRepository.findById(mealId);
    }
}
