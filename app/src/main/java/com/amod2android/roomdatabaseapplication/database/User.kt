package com.amod2android.roomdatabaseapplication.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class User(
    var name: String,
    var email: String,
    var avatar: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0 // or foodId: Int? = null
}
