package com.teamsparta.coffeemenu.domain.coffee.controller

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.service.CoffeeService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/coffee")
@RestController
class CoffeeController(
    private val coffeeService: CoffeeService
){

    @GetMapping
    fun getCoffee():ResponseEntity<List<CoffeeResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(coffeeService.getAllCoffeeList())
    }

}