package com.teamsparta.coffeemenu.domain.coffee.service

import com.teamsparta.coffeemenu.domain.coffee.dto.CoffeeResponse
import com.teamsparta.coffeemenu.domain.coffee.dto.CreateCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffee.dto.OrderCoffeeRequest
import com.teamsparta.coffeemenu.domain.coffee.model.Coffee
import com.teamsparta.coffeemenu.domain.coffee.model.toResponse
import com.teamsparta.coffeemenu.domain.coffee.repository.CoffeeRepository
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.dto.CoffeeOrderLineResponse
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.CoffeeOrderLine
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.model.toResponse
import com.teamsparta.coffeemenu.domain.coffeeOrderLine.repository.CoffeeOrderLineRepository
import com.teamsparta.coffeemenu.domain.user.repository.UserRepository
import com.teamsparta.courseregistration2.domain.exception.ModelNotFoundException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CoffeeServiceImpl(
    private val coffeeRepository: CoffeeRepository,
    private val userRepository: UserRepository,
    private val coffeeOrderLineRepository: CoffeeOrderLineRepository
) : CoffeeService {
    override fun getAllCoffeeList(): List<CoffeeResponse> {
        return coffeeRepository.findAll().map { it.toResponse() }
    }


    @Transactional
    override fun createCoffee(request: CreateCoffeeRequest): CoffeeResponse {
        return coffeeRepository.save(
            Coffee(
                name = request.name,
                content = request.content,
                price = request.price
            )
        ).toResponse()
    }

//    @Transactional
//    override fun orderMenu(userId:Long,request: OrderCoffeeRequest) {
//        val coffee = coffeeRepository.findByIdOrNull(request.id) ?: throw ModelNotFoundException("Coffee", request.id)
//        val user = userRepository.findByIdOrNull(userId) ?: throw ModelNotFoundException("User", userId)
//        var coffeePrice = coffee.price * request.count
//        var userPoint  = user.point
//
//        if(coffeePrice <= userPoint) {
//            userPoint -=coffeePrice
//            user.point = userPoint
//            userRepository.save(user)
//        }
//    }

    @Transactional

    override fun orderMenu(request: OrderCoffeeRequest) {
        val coffee = coffeeRepository.findByIdOrNull(request.id) ?: throw ModelNotFoundException("Coffee", request.id)
        val user = userRepository.findByIdOrNull(request.userId) ?: throw ModelNotFoundException("User", request.userId)

        //커피 가격 = 커피가격 * 주문횟수
        var coffeePrice = coffee.price * request.count
        var userPoint = user.point


        //커피 가격보다 유져 포인트가 많을 때 실행
        if (coffeePrice <= userPoint) {

            //커피 가격만큼 유져 포인트 차감
            userPoint -= coffeePrice
            user.point = userPoint
            userRepository.save(user)

            //커피 총 판매량 sellcount기록
            coffee.sell_count += request.count
            coffeeRepository.save(coffee)

            //판매기록에 커피 기록이 있는지 확인
            val orderLine: CoffeeOrderLine? = coffeeOrderLineRepository.findByIdOrNull(coffee.id)
            var coffeeOrderLine = CoffeeOrderLine(
                amount = request.count,
                coffee = coffee
            )
            coffeeOrderLineRepository.save(coffeeOrderLine)

        }

    }

    override fun beetMenu(): List<CoffeeOrderLineResponse> {

        //수많은 커피 구매 목록중 3가지만 보내기 위해 따로 list 생성
        var list = mutableListOf<CoffeeOrderLineResponse>()
        val allCoffeeOrderLine = coffeeOrderLineRepository.findAll().sortedByDescending { it.id }
        var count = 0


        while (count < 4) {


            //커피 전체 주문 내역
            for (i in 0..<allCoffeeOrderLine.size) {


                val coffee = coffeeRepository.findByIdOrNull(allCoffeeOrderLine[i].id)


                var tempList = CoffeeOrderLine(
                    id =0,
                    amount = allCoffeeOrderLine[i].amount,
                    coffee = coffee
                )

                println("================" )
                println(tempList)
                println("===================" )

                list.add(tempList.toResponse())

//                if (i == 0) {
//                    println("여기 리스트크기가 0 이면 여기온다")
//                    list.add(tempList.toResponse())
//                } else {
//                    for (i in 0..<list.size) {
//
//                        if (list[i].coffeeId == tempList.coffee?.id ) {
//                            list[i].amount += tempList.amount
//                            list.add(tempList.toResponse())
//                            println("여기는 몇번 오나 " + count)
//
//                        }
//                    }
//                }


                /////////////////

            count++
            }


            count = 4

        }


        println("여기 확인")
        println(list.size)

        //확인해보기
        for (i in 0..<list.size) {
            println("여기 확인")
            println(list[i])
            println("여기까지")

        }


        //일반 전체 조회
        return allCoffeeOrderLine.map { it.toResponse() }
    }
}