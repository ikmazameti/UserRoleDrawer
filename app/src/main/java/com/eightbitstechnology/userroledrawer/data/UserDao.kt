package com.eightbitstechnology.userroledrawer.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.eightbitstechnology.userroledrawer.data.model.User


@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User):Long

    @Query("SELECT * FROM users WHERE username = :username AND password = :password")
    suspend fun login(username: String, password: String): User?

    @Query("SELECT * FROM users WHERE username = :username")
    suspend fun getUserByUsername(username: String): User?
}
