package br.edu.fatecpg.com.listaandroid.dao

import br.edu.fatecpg.com.listaandroid.model.User

class UserDao {
    companion object{
        private val users = mutableListOf<User>()
    }

    fun addUser(user:User){
        users.add(user)
    }

    fun getUsers():List<User>{
        return users
    }
}