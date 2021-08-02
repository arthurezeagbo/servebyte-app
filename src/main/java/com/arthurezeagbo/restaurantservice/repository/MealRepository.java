package com.arthurezeagbo.restaurantservice.repository;

import com.arthurezeagbo.restaurantservice.model.Meal;
import com.arthurezeagbo.restaurantservice.model.ServiceProvider;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MealRepository extends JpaRepository<Meal, Long> {


}
