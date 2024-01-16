package com.teamsparta.coffeemenu.domain.user.model

import com.teamsparta.coffeemenu.domain.user.dto.UserResponse
import jakarta.persistence.*

@Entity
@Table(name = "app_user")
class User(

    @Column(name = "point")
    var point: Int = 0,


) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}

fun User.toResponse():UserResponse{
    return UserResponse(
        id = id!!,
        point = point
    )
}