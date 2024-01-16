package com.teamsparta.coffeemenu.domain.coffee.dto

data class CreateCoffeeRequest(
    val name:String,
    val content:String,
    val price:Int,
)
