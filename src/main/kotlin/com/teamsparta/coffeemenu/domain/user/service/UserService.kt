package com.teamsparta.coffeemenu.domain.user.service

import com.teamsparta.coffeemenu.domain.user.dto.SingUpRequest
import com.teamsparta.coffeemenu.domain.user.dto.UpdatePointRequest
import com.teamsparta.coffeemenu.domain.user.dto.UserResponse

interface UserService {

//    fun singUp(singUpRequest: SingUpRequest):UserResponse
fun singUp():UserResponse

//    fun updatePoint(userId:Long,updatePointRequest: UpdatePointRequest):UserResponse
fun updatePoint(updatePointRequest: UpdatePointRequest):UserResponse
}