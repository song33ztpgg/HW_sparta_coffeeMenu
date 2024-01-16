package com.teamsparta.coffeemenu.domain.coffee.controller

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.dto.CreateCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffee.dto.OrderCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffee.service.CoffeeService
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.dto.CoffeeOrderLineResponse
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.repository.CoffeeOrderLineRepository
import com.teamsparta.coffeemenu.domain.user.dto.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RequestMapping("/coffee")
@RestController
class CoffeeController(
    private val coffeeService: CoffeeService
) {

    //커피 목록 전체조회
    @GetMapping
    fun getCoffee():ResponseEntity<List<CoffeeResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(coffeeService.getAllCoffeeList())
    }

    //커피 제작
    @PostMapping
    fun createCoffee(@RequestBody createCoffeeRequest: CreateCoffeeRequest):ResponseEntity<CoffeeResponse>{
        return ResponseEntity
            .status(HttpStatus.CREATED)
            .body(coffeeService.createCoffee(createCoffeeRequest))
    }


    @PutMapping("/oderCoffee")
    fun orderMenu(
        @RequestBody orderCoffeeRequest: OrderCoffeeRequest
    ):ResponseEntity<Unit> {
        return ResponseEntity
            .status(HttpStatus.NO_CONTENT)
            .body(coffeeService.orderMenu(orderCoffeeRequest))

    }



    @GetMapping("/history")
    fun beetMenu():ResponseEntity<List<CoffeeOrderLineResponse>>{
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(coffeeService.beetMenu())
    }
}