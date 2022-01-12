package com.github.AdamczykK.meal;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MealRepositoryTest {

    MealRepository mealRepository = new MealRepository();

    @BeforeEach
    void cleanUp() {
        mealRepository.getAllMeals().clear();
    }

    @Test
    void shouldBeAbleToAddMealToRepository() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        //when
        mealRepository.add(meal);
        //then
        assertThat(mealRepository.getAllMeals().get(0), is(meal));
    }

    @Test
    void shouldBeAbleToRemoveMealFromRepository() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        mealRepository.add(meal);
        //when
        mealRepository.delete(meal);
        //then
        assertThat(mealRepository.getAllMeals(), not(contains(meal)));
    }

    @Test
    void shouldBeAbleToFindMealByExactName() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        Meal meal2 = new Meal(15, "Ha");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        //when
        List<Meal> results = mealRepository.findByName("Hamburger", true);
        //then
        assertThat(results.size(), equalTo(1));
    }

    @Test
    void shouldBeAbleToFindMealByStartingLetters() {
        Meal meal = new Meal(15, "Hamburger");
        Meal meal2 = new Meal(15, "Ha");
        mealRepository.add(meal);
        mealRepository.add(meal2);
        //when
        List<Meal> results = mealRepository.findByName("Ha", false);
        //then
        assertThat(results.size(), equalTo(2));
    }

    @Test
    void shouldBeAbleToFindMealByExactPrice() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        Meal meal1 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal1);
        //when
        List<Meal> results = mealRepository.findByPrice(15, MealPriceOperationType.EQUAL);
        //then
        assertThat(results.size(), equalTo(1));
    }

    @Test
    void shouldBeAbleToFindMealByLowerPrice() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        Meal meal1 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal1);
        //when
        List<Meal> results = mealRepository.findByPrice(21, MealPriceOperationType.LOWER);
        //then
        assertThat(results.size(), equalTo(2));
    }

    @Test
    void shouldBeAbleToFindMealByHigherPrice() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        Meal meal1 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal1);
        //when
        List<Meal> results = mealRepository.findByPrice(14, MealPriceOperationType.HIGHER);
        //then
        assertThat(results.size(), equalTo(2));
    }

    @Test
    void shouldBeAbleToFindMealByPriceAndName() {
        //given
        Meal meal = new Meal(15, "Hamburger");
        Meal meal1 = new Meal(20, "Pizza");
        mealRepository.add(meal);
        mealRepository.add(meal1);
        //when
        List<Meal> results = mealRepository.find("Ha", false, 16, MealPriceOperationType.LOWER);
        //then
        assertThat(results.size(), equalTo(1));
    }
}
