package com.teamsparta.coffeemenu.domain.coffee.model

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.CoffeeOrderLine
import jakarta.persistence.*

@Entity
@Table(name = "coffee")
class Coffee (
    @Column(name = "name", nullable = false)
    var name: String,

    @Column(name = "content")
    var content: String,

    @Column(name = "price", nullable = false)
    var price: Int,

    @Column(name = "sell_count", nullable = false)
    var sell_count: Int =0,

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun Coffee.toResponse():CoffeeResponse {
    return CoffeeResponse(
        id = id!!,
        name = name,
        content = content,
        price = price,
        sell_count = sell_count
    )
}