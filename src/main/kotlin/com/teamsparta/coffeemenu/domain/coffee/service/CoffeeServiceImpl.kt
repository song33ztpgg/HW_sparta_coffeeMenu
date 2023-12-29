package com.teamsparta.coffeemenu.domain.coffee.service

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.model.toResponse
import com.teamsparta.coffeemenu.domain.coffee.repository.CoffeeRepository
import org.springframework.stereotype.Service

@Service
class CoffeeServiceImpl(
    private val coffeeRepository: CoffeeRepository
) :CoffeeService {
    override fun getAllCoffeeList():List<CoffeeResponse>{
        return coffeeRepository.findAll().map{it.toResponse()}
    }
}