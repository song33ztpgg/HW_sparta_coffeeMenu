package com.teamsparta.coffeemenu.domain.coffee.service

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.dto.CreateCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffee.dto.OrderCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.dto.CoffeeOrderLineResponse
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.repository.CoffeeOrderLineRepository

interface CoffeeService {

    fun getAllCoffeeList(): List<CoffeeResponse>

    fun createCoffee(request: CreateCoffeeRequest): CoffeeResponse


    //    fun orderMenu(userId: Long, request: OrderCoffeeRequest)
    fun orderMenu( request: OrderCoffeeRequest)

    fun beetMenu(): List<CoffeeOrderLineResponse>

}