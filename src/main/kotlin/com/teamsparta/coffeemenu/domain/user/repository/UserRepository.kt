package com.teamsparta.coffeemenu.domain.user.repository

import com.teamsparta.coffeemenu.domain.user.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository:JpaRepository<User,Long> {
}