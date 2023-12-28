package com.teamsparta.coffeemenu

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CoffeeMenuApplication

fun main(args: Array<String>) {
    //커피API만들기
    runApplication<CoffeeMenuApplication>(*args)

}
