package com.teamsparta.courseregistration2.domain.exception

//RuntimeException Application이 실행될때 발생할수 있는예외

data class ModelNotFoundException(val modelName: String, val id: Long?) : RuntimeException(
        "Model $modelName not found with given id : $id")