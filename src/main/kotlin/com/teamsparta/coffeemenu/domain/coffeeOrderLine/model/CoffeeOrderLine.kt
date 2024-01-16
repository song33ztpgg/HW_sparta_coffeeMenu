package com.teamsparta.coffeemenu.domain.coffeeOrderLine.model

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.model.Coffee
import com.teamsparta.coffeemenu.domain.coffeeOrder.model.CoffeeOrder
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.dto.CoffeeOrderLineResponse
import jakarta.persistence.*

@Entity
@Table(name ="coffee_order_line")
class CoffeeOrderLine (
    val amount:Int,

//    //커피주문내역과 커피 1:1
//    @OneToOne(mappedBy = "coffeeOrderLine", fetch = FetchType.LAZY, cascade = [CascadeType.ALL], orphanRemoval = true)
//    var coffee: Coffee? =null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "coffee_id")
    var coffee: Coffee? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? =null

)

fun CoffeeOrderLine.toResponse(): CoffeeOrderLineResponse {

    return CoffeeOrderLineResponse(
        id = id!!,
        amount = amount,
        coffeeId = coffee?.id ?: -1
    )
}