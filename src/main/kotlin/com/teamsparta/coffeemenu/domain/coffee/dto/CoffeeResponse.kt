package com.teamsparta.coffeemenu.domain.coffee.dto

data class CoffeeResponse(
    val id : Long,
    val name :String,
    val content:String,
    val price:Int
)
