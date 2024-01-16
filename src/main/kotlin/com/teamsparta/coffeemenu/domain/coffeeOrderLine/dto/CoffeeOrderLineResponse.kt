package com.teamsparta.coffeemenu.domain.coffeeOrderLine.dto

import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.CoffeeOrderLine

data class CoffeeOrderLineResponse(
    val id:Long,
    var amount:Int,
    val coffeeId:Long?
){
    fun fromEntity(coffeeOrderLine: CoffeeOrderLine){

    }
}
