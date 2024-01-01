package com.eightbitstechnology.userroledrawer.ui.login

import android.app.Application
 import androidx.lifecycle.AndroidViewModel
  import com.eightbitstechnology.userroledrawer.MyApp
 import com.eightbitstechnology.userroledrawer.data.model.User

class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private val userDao = (application as MyApp).database.userDao()


    suspend fun register(user: User) {
        userDao.insert(user)
    }

    suspend fun login(username: String, password: String): User? {
        return userDao.login(username, password)
    }

    suspend fun getUserByUsername(username: String): User ?{
        return userDao.getUserByUsername(username)
    }



}