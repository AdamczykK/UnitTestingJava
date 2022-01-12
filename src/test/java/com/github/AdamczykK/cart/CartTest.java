package com.github.AdamczykK.cart;

import com.github.AdamczykK.meal.Meal;
import com.github.AdamczykK.order.Order;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;

class CartTest {

    @Test
    void simulateLargeOrder() {
        //given
        Cart cart = new Cart();
        //when + then
        assertTimeout(Duration.ofMillis(10), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart() {
        //given
        Order order = new Order();
        Cart cart = new Cart();
        //when
        cart.addOrderToCart(order);
        //then
        assertThat(cart.getOrders(), anyOf(
                notNullValue(),
                hasSize(0),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll("This is a group assertion",
                () -> assertThat(cart.getOrders(), notNullValue()),
                () -> assertThat(cart.getOrders(), is(not(empty()))),
                () -> assertThat(cart.getOrders(), is(not(emptyCollectionOf(Order.class)))),
                () -> assertThat(cart.getOrders(), hasSize(1)),
                () -> {
                    List<Meal> meals = cart.getOrders().get(0).getMeals();
                    assertThat(meals, emptyCollectionOf(Meal.class));
                }
        );

    }
}