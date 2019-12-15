package com.example.partygo.data

import com.example.partygo.User
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<User> {
        try {
            // TODO: handle loggedInUser authentication
            val newUser = User(username, "", arrayListOf(), 0)
            return Result.Success(newUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}

