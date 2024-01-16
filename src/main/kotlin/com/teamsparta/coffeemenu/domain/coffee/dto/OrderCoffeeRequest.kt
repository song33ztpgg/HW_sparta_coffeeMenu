package com.teamsparta.coffeemenu.domain.coffee.dto

data class OrderCoffeeRequest(
    val userId:Long,
    val id:Long,
    val count:Int
)
