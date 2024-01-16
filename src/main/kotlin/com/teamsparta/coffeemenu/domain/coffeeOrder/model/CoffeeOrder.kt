package com.teamsparta.coffeemenu.domain.coffeeOrder.model

import com.teamsparta.coffeemenu.domain.coffee.model.Coffee
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.CoffeeOrderLine
import jakarta.persistence.*

@Entity
@Table(name="coffeeOrder")
class CoffeeOrder(
    val totalpoint:Int,

    //커피주문과 커피주문내역 1:N
//    @OneToMany(mappedBy = "coffeeOrder", cascade = [CascadeType.ALL], orphanRemoval = true)
//    val coffeeOrderLine: MutableList<CoffeeOrderLine> = mutableListOf()

) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id:Long? =null
}