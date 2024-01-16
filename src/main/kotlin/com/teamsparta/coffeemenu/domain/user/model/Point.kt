package com.teamsparta.coffeemenu.domain.user.model

import jakarta.persistence.Column
import jakarta.persistence.Embeddable
import jakarta.persistence.Embedded

@Embeddable
data class Point(
    @Column(name = "point")
    var point:Int
)
