package com.watasolutions.week7_t6.database


class UserRepository(private val userDAO: UserDao) {
    suspend fun repoLoadUsersList() : List<User>{
        return userDAO.getAllUsers()
    }

    suspend fun repoAddUser(user : User){
        userDAO.addUser(user)
    }
}