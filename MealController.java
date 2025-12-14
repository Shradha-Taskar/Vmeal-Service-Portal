package com.project.vmeal.Controller;

import com.project.vmeal.Entity.Meal;
import com.project.vmeal.Service.MealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

        import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/meals")
@CrossOrigin(origins = "*")
public class MealController {

    @Autowired
    private MealService mealService;

    // Create/Add new Meal
    @PostMapping("/add")
    public Meal addMeal(@RequestBody Meal meal) {
        return mealService.addMeal(meal);
    }

    // Get all Meals
    @GetMapping("/all")
    public List<Meal> getAllMeals() {
        return mealService.getAllMeals();
    }

    // Get Meal by ID
    @GetMapping("/{id}")
    public Optional<Meal> getMealById(@PathVariable Long id) {
        return mealService.getMealById(id);
    }

    // Update Meal
    @PutMapping("/update/{id}")
    public Meal updateMeal(@PathVariable Long id, @RequestBody Meal meal) {
        return mealService.updateMeal(id, meal);
    }

    // Delete Meal
    @DeleteMapping("/delete/{id}")
    public String deleteMeal(@PathVariable Long id) {
        mealService.deleteMeal(id);
        return "Meal deleted with id: " + id;
    }
}

