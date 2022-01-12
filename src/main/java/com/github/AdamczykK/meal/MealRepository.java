package com.github.AdamczykK.meal;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MealRepository {

    private List<Meal> meals = new ArrayList<>();

    public void add(Meal meal) {
        meals.add(meal);
    }

    public List<Meal> getAllMeals() {
        return meals;
    }

    public void delete(Meal meal) {
        meals.remove(meal);
    }

    public List<Meal> findByName(String name, boolean exactMatch) {
        List<Meal> results;
        if(exactMatch) {
            results = meals.stream().filter(meal -> meal.getName().equals(name)).collect(Collectors.toList());
        } else {
            results = meals.stream().filter(meal -> meal.getName().startsWith(name)).collect(Collectors.toList());
        }
        return results;
    }

    public List<Meal> findByPrice(int price, MealPriceOperationType operationType) {
        List<Meal> results;
        switch (operationType) {
            case EQUAL:
                results = meals.stream().filter(meal -> meal.getPrice() == price).collect(Collectors.toList());
                break;
            case HIGHER:
                results =  meals.stream().filter(meal -> meal.getPrice() > price).collect(Collectors.toList());
                break;
            default:
                results= meals.stream().filter(meal -> meal.getPrice() < price).collect(Collectors.toList());
        }
        return results;
    }

    public List<Meal> find(String name, boolean exactMatch, int price, MealPriceOperationType operationType) {
        List<Meal> results;
        if(exactMatch) {
            results = findByPrice(price, operationType).stream().filter(meal -> meal.getName().equals(name)).collect(Collectors.toList());
        } else {
            results = findByPrice(price, operationType).stream().filter(meal -> meal.getName().startsWith(name)).collect(Collectors.toList());
        }
        return results;
    }
}
