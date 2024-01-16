package com.teamsparta.coffeemenu.domain.coffee.repository

import com.teamsparta.coffeemenu.domain.coffee.model.Coffee
import org.springframework.data.jpa.repository.JpaRepository

interface CoffeeRepository:JpaRepository<Coffee,Long> {
}