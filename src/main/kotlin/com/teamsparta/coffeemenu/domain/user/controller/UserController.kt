package com.teamsparta.coffeemenu.domain.user.controller

import com.teamsparta.coffeemenu.domain.user.dto.SingUpRequest
import com.teamsparta.coffeemenu.domain.user.dto.UpdatePointRequest
import com.teamsparta.coffeemenu.domain.user.dto.UserResponse
import com.teamsparta.coffeemenu.domain.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UserController(
    private val userService: UserService
) {
//    @PostMapping("/singup")
//    fun singUp(@RequestBody singUpRequest: SingUpRequest):ResponseEntity<UserResponse>{
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(userService.singUp(singUpRequest))
//    }

    //point값이 0인 id 생성
    @PostMapping("/singup")
    fun singUp(): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.singUp())
    }


//    @PutMapping("/{userId}/point")
//    fun login(
//        @PathVariable userId: Long,
//        @RequestBody point: Int
//    ): ResponseEntity<UserResponse> {
//        return ResponseEntity
//            .status(HttpStatus.OK)
//            .body(userService.updatePoint(userId, point))
//    }


    @PutMapping("/chargePoint")
    fun login(
        @RequestBody updatePointRequest: UpdatePointRequest
    ): ResponseEntity<UserResponse> {
        return ResponseEntity
            .status(HttpStatus.OK)
            .body(userService.updatePoint(updatePointRequest))
    }

}