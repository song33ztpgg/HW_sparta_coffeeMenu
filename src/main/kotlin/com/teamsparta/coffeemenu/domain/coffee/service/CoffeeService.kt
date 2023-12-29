package com.teamsparta.coffeemenu.domain.coffee.service

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse

interface CoffeeService {

    fun getAllCoffeeList():List<CoffeeResponse>
}