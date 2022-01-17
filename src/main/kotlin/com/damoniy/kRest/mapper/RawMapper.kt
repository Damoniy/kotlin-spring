package com.damoniy.kRest.mapper

interface RawMapper<T, U> {
    fun map(t: T): U
}
