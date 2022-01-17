package com.damoniy.kRest.service

import com.damoniy.kRest.model.User
import org.springframework.stereotype.Service
import java.util.*

@Service
data class UserService(var users: List<User>) {

    init {
        val user = User(id = 0, name = "Acenélio", "acenelio@gmail.com")
        users = Arrays.asList(user)
    }

    fun findById(id: Long): User {
        return users.stream().filter { u -> u.id == id }.findFirst().get()
    }
}