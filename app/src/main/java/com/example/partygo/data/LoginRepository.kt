package com.example.partygo.data

import com.example.partygo.User
import com.example.partygo.user1

class LoginRepository(val dataSource: LoginDataSource) {

    var user: User? = null
        private set

    val isLoggedIn: Boolean
        get() = user != null

    init {
        user = user1
    }

    fun logout() {
        user = null
        dataSource.logout()
    }

    fun login(username: String, password: String): Result<User> {
        val result = dataSource.login(username, password)

        if (result is Result.Success) {
            setLoggedInUser(result.data)
        }

        return result
    }

    private fun setLoggedInUser(loggedInUser: User) {
        this.user = loggedInUser
    }
}
