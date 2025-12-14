package com.project.vmeal.Service;

import com.project.vmeal.Entity.Meal;
import com.project.vmeal.Repository.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    // Create or Add new Meal
    public Meal addMeal(Meal meal) {
        return mealRepository.save(meal);
    }

    // Get all Meals
    public List<Meal> getAllMeals() {
        return mealRepository.findAll();
    }

    // Get Meal by ID
    public Optional<Meal> getMealById(Long id) {
        return mealRepository.findById(id);
    }

    // Update Meal
    public Meal updateMeal(Long id, Meal mealDetails) {
        Meal meal = mealRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Meal not found with id: " + id));

        meal.setName(mealDetails.getName());
        meal.setDescription(mealDetails.getDescription());
        meal.setPrice(mealDetails.getPrice());
        meal.setType(mealDetails.getType());

        return mealRepository.save(meal);
    }

    // Delete Meal
    public void deleteMeal(Long id) {
        mealRepository.deleteById(id);
    }
}
