package com.teamsparta.coffeemenu.domain.coffee.model

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "coffee")
class Coffee(

    @Column(name = "name")
    var name: String,


    @Column(name = "content")
    var content: String,

    @Column(name = "price")
    var price: Int

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? =null
}

fun Coffee.toResponse():CoffeeResponse{
    return CoffeeResponse(
        id =id!!,
        name =name,
        content=content,
        price = price
    )
}