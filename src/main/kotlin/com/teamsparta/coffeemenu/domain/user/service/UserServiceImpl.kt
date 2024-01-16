package com.teamsparta.coffeemenu.domain.user.service

import com.teamsparta.coffeemenu.domain.user.dto.SingUpRequest
import com.teamsparta.coffeemenu.domain.user.dto.UpdatePointRequest
import com.teamsparta.coffeemenu.domain.user.dto.UserResponse
import com.teamsparta.coffeemenu.domain.user.model.Point
import com.teamsparta.coffeemenu.domain.user.model.User
import com.teamsparta.coffeemenu.domain.user.model.toResponse
import com.teamsparta.coffeemenu.domain.user.repository.UserRepository
import com.teamsparta.courseregistration2.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserServiceImpl(
    private val userRepository: UserRepository
) : UserService {

//    @Transactional
//    override fun singUp(request: SingUpRequest): UserResponse {
//        return userRepository.save(
//            User(
//               point = 0
//            )
//        ).toResponse()
//    }


    //첫 id 생성시 point 0 값으로 생성
    @Transactional
    override fun singUp(): UserResponse {
        return userRepository.save(
            User(
                point = 0
            )
        ).toResponse()
    }

//    @Transactional
//    override fun updatePoint(userId: Long, request: UpdatePointRequest): UserResponse {
//        val user = userRepository.findByIdOrNull(userId)
//
//        val (title, description) = request
//
////        user.point = Point(
////            point = request.point
////        )
//
//        return userRepository.save(user).toResponse()
//    }

    @Transactional
    override fun updatePoint(request: UpdatePointRequest): UserResponse {
        val user = userRepository.findByIdOrNull(request.id) ?: throw ModelNotFoundException("User",request.id)
        user.point += request.point

        return userRepository.save(user).toResponse()
    }
}