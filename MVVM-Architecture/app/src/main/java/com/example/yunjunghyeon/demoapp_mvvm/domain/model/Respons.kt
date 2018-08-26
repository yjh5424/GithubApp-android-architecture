package com.example.yunjunghyeon.demoapp_mvvm.domain.model


class Response<T> constructor(
        val status: Status,
        val data: T?,
        val throwable: Throwable?
) {
        companion object {
                fun <T> success(data: T?): Response<T> = Response(Status.SUCCESS, data, null)
                fun <T> error(throwable: Throwable?): Response<T> = Response(Status.ERROR, null, throwable)
                fun <T> loading(): Response<T> = Response(Status.LOADING, null, null)
        }
}


enum class Status{
        LOADING,
        SUCCESS,
        ERROR
}

