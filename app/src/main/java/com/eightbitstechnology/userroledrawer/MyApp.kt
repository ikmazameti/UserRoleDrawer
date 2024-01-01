package com.eightbitstechnology.userroledrawer

import android.app.Application
import androidx.room.Room
import com.eightbitstechnology.userroledrawer.data.AppDatabase

class MyApp : Application() {
    val database by lazy {
        Room.databaseBuilder(this, AppDatabase::class.java, "my-database")
            .fallbackToDestructiveMigration()
            .build()
    }
}
