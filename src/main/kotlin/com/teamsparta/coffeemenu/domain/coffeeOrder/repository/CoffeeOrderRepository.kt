package com.teamsparta.coffeemenu.domain.coffeeOrder.repository

import com.teamsparta.coffeemenu.domain.coffeeOrder.model.CoffeeOrder
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeOrderRepository:JpaRepository<CoffeeOrder,Long> {
}