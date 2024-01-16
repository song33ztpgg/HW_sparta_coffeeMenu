package com.teamsparta.coffeemenu.domain.coffeeOrderLine.repository

import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.CoffeeOrderLine
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeOrderLineRepository:JpaRepository<CoffeeOrderLine,Long> {
}