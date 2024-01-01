package com.eightbitstechnology.userroledrawer.ui.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.eightbitstechnology.userroledrawer.MyApp
import com.eightbitstechnology.userroledrawer.data.model.User

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val userDao = (application as MyApp).database.userDao()


    suspend fun getUserByUsername(username: String): User? {
        return userDao.getUserByUsername(username)
    }

}