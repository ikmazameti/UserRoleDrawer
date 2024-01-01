package com.eightbitstechnology.userroledrawer.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.eightbitstechnology.userroledrawer.data.model.User


@Database(
    entities = [User::class], version = 5, exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}


