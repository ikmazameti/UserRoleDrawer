package com.eightbitstechnology.userroledrawer.data.model

import android.os.Parcelable
import androidx.annotation.Keep
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Keep
@Parcelize
@Entity(tableName = "users")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val userNumber: String = java.util.UUID.randomUUID().toString(),
    val username: String,
    val password: String,
    val role: Int = 0,//user = 0 or admin = 1
    val firstName: String,
    val otherName: String,
) : Parcelable